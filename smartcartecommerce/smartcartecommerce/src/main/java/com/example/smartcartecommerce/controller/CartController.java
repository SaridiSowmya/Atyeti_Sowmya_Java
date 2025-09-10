package com.example.smartcartecommerce.controller;
import com.example.smartcartecommerce.model.CartItem;
import com.example.smartcartecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartItem> add(@RequestBody Map<String, Object> body) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer productId = (Integer) body.get("productId");
        Integer qty = (Integer) body.getOrDefault("quantity", 1);
        return ResponseEntity.ok(cartService.addToCart(username, productId, qty));
    }

    @GetMapping
    public List<CartItem> view() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return cartService.viewCart(username);
    }
}

