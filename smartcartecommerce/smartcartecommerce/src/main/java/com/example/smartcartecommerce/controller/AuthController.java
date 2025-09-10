package com.example.smartcartecommerce.controller;

import com.example.smartcartecommerce.dto.*;
import com.example.smartcartecommerce.model.User;
import com.example.smartcartecommerce.security.CustomUserDetailsService;
import com.example.smartcartecommerce.security.JwtUtil;
import com.example.smartcartecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authManager;
  private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        User u = userService.register(req);
        return ResponseEntity.ok("user registered: " + u.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        Authentication a = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        UserDetails ud = (UserDetails) a.getPrincipal();
        String token = jwtUtil.generateToken(ud.getUsername(), ud.getAuthorities().stream().findFirst().get().getAuthority());
        String role = ud.getAuthorities().stream().findFirst().get().getAuthority().replace("ROLE_", "");
        return ResponseEntity.ok(new JwtResponse(token, ud.getUsername(), role));
    }
}
