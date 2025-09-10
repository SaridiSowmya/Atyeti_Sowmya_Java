package com.example.smartcartecommerce.repository;

import com.example.smartcartecommerce.model.Orders;
import com.example.smartcartecommerce.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.user = :user ORDER BY o.createdAt DESC")
    List<Orders> findOrdersByUser(@Param("user") User user);

    @Query("SELECT COALESCE(SUM(o.totalPrice),0) FROM Orders o")
    Double totalRevenue();
}

