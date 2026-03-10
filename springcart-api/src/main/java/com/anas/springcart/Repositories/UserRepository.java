package com.anas.springcart.Repositories;

import com.anas.springcart.Models.UserModel;
import com.anas.springcart.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findByRoles(Role role);
    Optional<UserModel> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
