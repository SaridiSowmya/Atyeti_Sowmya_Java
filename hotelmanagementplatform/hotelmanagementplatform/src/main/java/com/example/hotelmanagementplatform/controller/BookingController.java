package com.example.hotelmanagementplatform.controller;

import com.example.hotelmanagementplatform.model.Booking;
import com.example.hotelmanagementplatform.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(
            @RequestParam int userId,
            @RequestParam int roomId,
            @RequestBody Booking bookingRequest) {
        return ResponseEntity.ok(bookingService.createBooking(userId, roomId, bookingRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable int id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
