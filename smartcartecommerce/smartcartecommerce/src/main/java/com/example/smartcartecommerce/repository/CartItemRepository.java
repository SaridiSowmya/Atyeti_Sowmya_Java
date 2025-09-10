package com.example.smartcartecommerce.repository;

import com.example.smartcartecommerce.model.CartItem;
import com.example.smartcartecommerce.model.User;
import com.example.smartcartecommerce.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query("SELECT c FROM CartItem c WHERE c.user = :user")
    List<CartItem> findByUser(@Param("user") User user);

    @Query("SELECT c FROM CartItem c WHERE c.user = :user AND c.product = :product")
    Optional<CartItem> findByUserAndProduct(@Param("user") User user, @Param("product") Product product);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.user = :user")
    void deleteByUser(@Param("user") User user);
}

