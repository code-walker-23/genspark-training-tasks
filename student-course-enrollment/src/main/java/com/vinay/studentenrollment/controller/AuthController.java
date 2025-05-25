package com.vinay.studentenrollment.controller;

import com.vinay.studentenrollment.dto.RegisterRequest;
import com.vinay.studentenrollment.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        String result = authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/signin")
    public ResponseEntity<String> signin(Authentication authentication) {
        if (authentication != null) {
            String message = "User '" + authentication.getName() + "' signed in successfully.";
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
