package com.vinay.studentenrollment.service;

import com.vinay.studentenrollment.exception.UserAlreadyExistsException;
import com.vinay.studentenrollment.models.User;
import com.vinay.studentenrollment.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String rawPassword, String role) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("User already exists with username: " + username);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role.toUpperCase());  // Normalize role to uppercase

        return userRepository.save(user);
    }
}
