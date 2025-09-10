package com.example.smartcartecommerce.repository;

import com.example.smartcartecommerce.model.DiscountCoupon;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<DiscountCoupon, Integer> {

    @Query("SELECT c FROM DiscountCoupon c WHERE c.code = :code AND c.active = true")
    Optional<DiscountCoupon> findActiveCouponByCode(@Param("code") String code);
}

