package com.anas.springcart.Services;

import com.anas.springcart.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    List<UserDTO> getUsersByRole(Integer roleId);

    UserDTO updateUser(Integer id, UserDTO userDTO);

    void deleteUser(Integer id);
}