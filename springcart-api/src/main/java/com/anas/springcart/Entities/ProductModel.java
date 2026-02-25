package com.anas.springcart.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;


public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String description;
    private DateTimeFormat date;

    public ProductModel(String name, String description, DateTimeFormat date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DateTimeFormat getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(DateTimeFormat date) {
        this.date = date;
    }
}
