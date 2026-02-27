package com.anas.springcart.Entities;

import jakarta.persistence.*;

import java.util.List;

public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    private String name;
    @ManyToMany
    private List <UserModel> users;

    public Role(String name, List<UserModel> users) {
        this.name = name;
        this.users = users;
    }
}
