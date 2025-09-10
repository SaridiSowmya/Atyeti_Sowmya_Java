package com.example.smartcartecommerce.service;

import com.example.smartcartecommerce.model.DiscountCoupon;
import com.example.smartcartecommerce.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepo;

    public Optional<DiscountCoupon> findActive(String code) {
        return couponRepo.findActiveCouponByCode(code);
    }

    public DiscountCoupon save(DiscountCoupon coupon) {
        return couponRepo.save(coupon);
    }

    public List<DiscountCoupon> findAll() {
        return couponRepo.findAll();
    }
}
