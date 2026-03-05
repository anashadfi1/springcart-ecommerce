package com.anas.springcart.Repositories;

import com.anas.springcart.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
}
