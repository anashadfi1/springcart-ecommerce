package com.anas.springcart.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="product_table")
public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String description;
    private LocalDateTime date;
    private String imageUrl;

    public ProductModel(String name, String description, LocalDateTime date, String imageUrl) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.imageUrl = imageUrl;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
