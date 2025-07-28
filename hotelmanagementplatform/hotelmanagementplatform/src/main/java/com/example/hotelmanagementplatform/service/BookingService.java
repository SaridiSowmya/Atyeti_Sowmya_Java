package com.example.hotelmanagementplatform.service;
import com.example.hotelmanagementplatform.model.Booking;
import com.example.hotelmanagementplatform.model.Room;
import com.example.hotelmanagementplatform.model.User;
import com.example.hotelmanagementplatform.repository.BookingRepository;
import com.example.hotelmanagementplatform.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    public Booking createBooking(int userId, int roomId, Booking bookingRequest) {
        User user = userService.getUserById(userId);
        Room room = roomService.getRoomById(roomId);

        if (!room.isAvailable()) {
            throw new RuntimeException("Room not available");
        }

        bookingRequest.setUser(user);
        bookingRequest.setRoom(room);
        room.setAvailable(false);

        return bookingRepository.save(bookingRequest);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Room room = booking.getRoom();
        room.setAvailable(true); // make room available again

        bookingRepository.delete(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public void cancelExpiredUnpaidBookings() {
        List<Booking> expiredUnpaidBookings = bookingRepository.findByPaidFalseAndCheckInBefore(LocalDate.now());

        for (Booking booking : expiredUnpaidBookings) {
            Room room = booking.getRoom();
            room.setAvailable(true);
            roomRepository.save(room);
            bookingRepository.delete(booking);
        }
    }

}

