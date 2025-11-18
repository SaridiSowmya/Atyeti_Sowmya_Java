package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.dto.AuthResponse;
import com.example.orderprocessingsystem.dto.LoginRequest;
import com.example.orderprocessingsystem.model.User;
import com.example.orderprocessingsystem.repository.UserRepository;
import com.example.orderprocessingsystem.security.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserRepository userRepo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User dbUser = userRepo.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
        return new AuthResponse(token, dbUser.getUsername(), dbUser.getRole());
    }

}

