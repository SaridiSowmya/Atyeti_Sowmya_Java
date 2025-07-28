package com.example.hotelmanagementplatform.repository;


import com.example.hotelmanagementplatform.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByPaidFalseAndCheckInBefore(LocalDate date);

}