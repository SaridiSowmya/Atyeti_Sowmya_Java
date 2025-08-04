package com.example.CSVfileImporterandValidator.repository;

import com.example.CSVfileImporterandValidator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
