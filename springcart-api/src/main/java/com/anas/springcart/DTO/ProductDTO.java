package com.anas.springcart.DTO;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductDTO {
    private Integer id;
    private Integer name;
    private String description;
    private String imageUrl;
    private DateTimeFormat date;

    public ProductDTO(Integer name, String description, String imageUrl, DateTimeFormat date, Integer id) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.date = date;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DateTimeFormat getDate() {
        return date;
    }

    public void setDate(DateTimeFormat date) {
        this.date = date;
    }
}
