package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.dto.RegisterRequest;
import com.vinay.studentenrollment.exception.UsernameAlreadyExistsException;
import com.vinay.studentenrollment.models.User;
import com.vinay.studentenrollment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username '" + request.getUsername() + "' already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole().toUpperCase());

        userRepository.save(user);
        return "User registered successfully";
    }
}
