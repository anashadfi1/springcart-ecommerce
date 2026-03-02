package com.anas.springcart.Repositories;

import com.anas.springcart.Entities.Role;
import com.anas.springcart.Entities.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleType name);

    boolean existsByName(RoleType name);
}