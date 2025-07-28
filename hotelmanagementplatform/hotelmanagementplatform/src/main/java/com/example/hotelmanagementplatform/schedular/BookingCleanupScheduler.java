package com.example.hotelmanagementplatform.schedular;


import com.example.hotelmanagementplatform.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingCleanupScheduler {

    private final BookingService bookingService;

    @Scheduled(fixedRate = 3600000)
    public void autoCancelUnpaidBookings() {
        bookingService.cancelExpiredUnpaidBookings();
    }
}
