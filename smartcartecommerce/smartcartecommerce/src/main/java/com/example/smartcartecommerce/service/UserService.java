package com.example.smartcartecommerce.service;
import com.example.smartcartecommerce.dto.SignupRequest;
import com.example.smartcartecommerce.exception.InvalidRequestException;
import com.example.smartcartecommerce.model.Role;
import com.example.smartcartecommerce.model.User;
import com.example.smartcartecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public User register(SignupRequest req) {
        if (req.getUsername() == null || req.getPassword() == null)
            throw new InvalidRequestException("username/password required");
        if (userRepo.existsByUsername(req.getUsername()))
            throw new InvalidRequestException("username already exists");
        User u = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .name(req.getName())
                .email(req.getEmail())
                //.role(Role.CUSTOMER)
                .role(req.getRole())
                .build();
        return userRepo.save(u);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }
}
