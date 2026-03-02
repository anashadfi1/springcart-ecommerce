package com.anas.springcart.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles;

    public UserModel() {
    }

    public UserModel(String username, String email, String password, List<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

