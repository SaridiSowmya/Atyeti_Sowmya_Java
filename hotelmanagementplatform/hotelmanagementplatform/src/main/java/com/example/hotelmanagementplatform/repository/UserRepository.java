package com.example.hotelmanagementplatform.repository;

import com.example.hotelmanagementplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}