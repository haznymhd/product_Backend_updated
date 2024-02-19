package com.hasni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasni.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}