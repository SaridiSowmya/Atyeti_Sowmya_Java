package com.example.orderprocessingsystem.repository;
import com.example.orderprocessingsystem.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {}

