package com.example.hotelmanagementplatform.repository;

import com.example.hotelmanagementplatform.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByAvailableTrue();
}
