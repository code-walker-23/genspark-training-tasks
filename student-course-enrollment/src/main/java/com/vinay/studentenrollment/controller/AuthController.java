package com.vinay.studentenrollment.controller;

import com.vinay.studentenrollment.dto.RegisterRequest;
import com.vinay.studentenrollment.repository.UserRepository;
import com.vinay.studentenrollment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String register(@RequestBody RegisterRequest request) {
        return authService.registerUser(request);
    }

    @GetMapping("/signin")
    public String signin(Authentication authentication) {
        // Spring injects the currently authenticated user
        if (authentication != null) {
            return "User '" + authentication.getName() + "' signed in successfully.";
        } else {
            return "Invalid credentials";
        }
    }
}
