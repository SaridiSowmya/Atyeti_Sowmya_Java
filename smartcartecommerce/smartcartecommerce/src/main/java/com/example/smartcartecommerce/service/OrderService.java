package com.example.smartcartecommerce.service;

import com.example.smartcartecommerce.exception.ResourceNotFoundException;
import com.example.smartcartecommerce.model.*;
import com.example.smartcartecommerce.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;
    private final CartService cartService;
    private final CouponRepository couponRepo;

    @Transactional
    public Orders checkout(String username,String couponCode) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        List<CartItem> items = cartRepo.findByUser(user);
        if (items.isEmpty()) throw new ResourceNotFoundException("Cart is empty");

        double total = 0;
        for (CartItem ci : items) {
            Product p = productRepo.findById(ci.getProduct().getId()).orElseThrow();
            if (p.getStock() < ci.getQuantity()) throw new ResourceNotFoundException("Out of stock: " + p.getName());
            total += p.getPrice() * ci.getQuantity();
            p.setStock(p.getStock() - ci.getQuantity());
            productRepo.save(p);
        }


        if (couponCode != null && !couponCode.isEmpty()) {
            DiscountCoupon coupon = couponRepo.findActiveCouponByCode(couponCode)
                    .orElseThrow(() -> new ResourceNotFoundException("Invalid or inactive coupon"));
            total = total - (total * coupon.getDiscountPercent() / 100);
        }


        Orders order = Orders.builder()
                .user(user)
                .totalPrice(total)
                .createdAt(LocalDateTime.now())
                .build();
        Orders saved = orderRepo.save(order);


        //cartRepo.deleteByUser(user);
        cartService.clearCart(user);

        return saved;
    }

    public List<Orders> history(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return orderRepo.findOrdersByUser(user);
    }
}

