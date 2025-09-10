package com.example.smartcartecommerce.controller;

import com.example.smartcartecommerce.model.DiscountCoupon;
import com.example.smartcartecommerce.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;


    @PostMapping
    public ResponseEntity<DiscountCoupon> createCoupon(@RequestBody DiscountCoupon coupon) {
        DiscountCoupon saved = couponService.save(coupon);
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public ResponseEntity<List<DiscountCoupon>> getAllCoupons() {
        return ResponseEntity.ok(couponService.findAll());
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<DiscountCoupon> validateCoupon(@PathVariable String code) {
        return couponService.findActive(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

