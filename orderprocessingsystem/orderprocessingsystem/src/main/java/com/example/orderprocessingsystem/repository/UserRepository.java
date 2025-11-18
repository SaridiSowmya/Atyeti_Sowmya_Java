package com.example.orderprocessingsystem.repository;
import com.example.orderprocessingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

}
