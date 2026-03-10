package com.anas.springcart.Services;

import com.anas.springcart.Exceptions.ResourceNotFoundException;
import com.anas.springcart.Models.RefreshToken;
import com.anas.springcart.Models.UserModel;
import com.anas.springcart.Repositories.RefreshTokenRepository;
import com.anas.springcart.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    @Value("${jwt.refresh-expiration}")
    private long refreshExpiration; // in milliseconds

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Transactional
    public RefreshToken createRefreshToken(String username) {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));

        // Delete any existing refresh token for this user (one token per user)
        refreshTokenRepository.deleteByUser(user);

        RefreshToken refreshToken = RefreshToken.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(refreshExpiration))
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken validateRefreshToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new AccessDeniedException("Refresh token not found"));

        if (refreshToken.isExpired()) {
            refreshTokenRepository.delete(refreshToken);
            throw new AccessDeniedException("Refresh token has expired, please login again");
        }

        return refreshToken;
    }

    @Transactional
    public void deleteByUsername(String username) {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
        refreshTokenRepository.deleteByUser(user);
    }
}
