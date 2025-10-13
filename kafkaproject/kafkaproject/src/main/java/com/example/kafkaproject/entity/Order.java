package com.example.kafkaproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private int quantity;
    private String status; // PLACED, CONFIRMED, SHIPPED, DELIVERED

    public Order() {}

    public Order(String productName, int quantity, String status) {
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
