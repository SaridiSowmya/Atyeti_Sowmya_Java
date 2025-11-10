package com.example.orderprocessingsystem.repository;
import com.example.orderprocessingsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
