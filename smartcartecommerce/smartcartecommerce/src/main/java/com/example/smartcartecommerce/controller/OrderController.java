package com.example.smartcartecommerce.controller;

import com.example.smartcartecommerce.model.Orders;
import com.example.smartcartecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
//
//    @PostMapping("/checkout")
//    public ResponseEntity<Orders> checkout() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return ResponseEntity.ok(orderService.checkout(username,couponCode));
//    }


    @PostMapping("/checkout")
    public ResponseEntity<Orders> checkout(@RequestParam(required = false) String couponCode) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(orderService.checkout(username, couponCode));
    }

    @GetMapping("/history")
    public List<Orders> history() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return orderService.history(username);
    }

}

