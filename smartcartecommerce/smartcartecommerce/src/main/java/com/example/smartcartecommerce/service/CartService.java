package com.example.smartcartecommerce.service;
import com.example.smartcartecommerce.exception.ResourceNotFoundException;
import com.example.smartcartecommerce.model.*;
import com.example.smartcartecommerce.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    @Transactional
    public CartItem addToCart(String username, Integer productId, int qty) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        var existing = cartRepo.findByUserAndProduct(user, product);
        if (existing.isPresent()) {
            CartItem c = existing.get();
            c.setQuantity(c.getQuantity() + qty);
            return cartRepo.save(c);
        } else {
            CartItem c = CartItem.builder().user(user).product(product).quantity(qty).build();
            return cartRepo.save(c);
        }
    }

    public List<CartItem> viewCart(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return cartRepo.findByUser(user);
    }

    @Transactional
    public void clearCart(User user) {
        cartRepo.deleteByUser(user);
    }
}

