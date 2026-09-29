package com.example.crud.serivce;

import org.springframework.stereotype.Service;
import com.example.crud.dto.LoginRequest;
import com.example.crud.dto.LoginResponse;
import com.example.crud.dto.RegisterRequest;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // REGISTER
    public Map<String, String> register(RegisterRequest request) {

        // Check whether username already exists
        if (userRepository
                .findByUsername(request.getUsername())
                .isPresent()) {

            throw new RuntimeException(
                    "Username already exists"
            );
        }

        // Hash password
        String encodedPassword =
                passwordEncoder.encode(
                        request.getPassword()
                );

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(encodedPassword);

        // Save to MongoDB
        userRepository.save(user);

        return Map.of("message","Registration successful");
    }

    // LOGIN
    public LoginResponse login(
            LoginRequest request) {

        // Find user
        User user =
                userRepository
                        .findByUsername(
                                request.getUsername()
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid username or password"
                                )
                        );

        // Check password
        boolean validPassword =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!validPassword) {

            throw new RuntimeException(
                    "Invalid username or password"
            );
        }

        // Generate JWT
        String token =
                jwtService.generateToken(
                        user.getUsername()
                );

        return new LoginResponse(
                token,
                user.getUsername()
        );
    }
}
