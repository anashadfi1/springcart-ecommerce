package com.anas.springcart.Services;

import com.anas.springcart.DTO.UserDTO;
import com.anas.springcart.Entities.Role;
import com.anas.springcart.Entities.UserModel;
import com.anas.springcart.Repositories.RoleRepository;
import com.anas.springcart.Repositories.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO dto) {

        UserModel user = new UserModel();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(dto.getRoles());

        UserModel savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersByRole(Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return userRepository.findByRoles(role)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO dto) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        user.setRoles(dto.getRoles());

        return mapToDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // =========================
    // Mapping helpers
    // =========================
    private UserDTO mapToDTO(UserModel user) {
        UserDTO dto = new UserDTO(
                user.getUsername(),
                user.getEmail(),
                null, // NEVER expose password
                user.getRoles()
        );
        dto.setId(user.getId());
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}