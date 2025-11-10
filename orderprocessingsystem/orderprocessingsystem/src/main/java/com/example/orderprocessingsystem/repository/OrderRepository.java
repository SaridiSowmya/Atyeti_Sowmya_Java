package com.example.orderprocessingsystem.repository;
import com.example.orderprocessingsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}