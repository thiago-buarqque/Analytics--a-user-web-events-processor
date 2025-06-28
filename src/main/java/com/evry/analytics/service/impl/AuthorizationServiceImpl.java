package com.evry.analytics.service.impl;

import com.evry.analytics.model.entity.User;
import com.evry.analytics.repository.UserRepository;

import com.evry.analytics.security.exception.SecurityException;
import com.evry.analytics.service.AuthorizationService;
import com.evry.analytics.model.enums.UserRole;
import com.evry.analytics.service.JwtService;
import com.evry.analytics.model.response.JwtAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public JwtAuthenticationResponse signup(User user) {
        Optional<User> userOptional = userRepository.findByEmail(
                user.getEmail());

        if (userOptional.isPresent()) {
            throw new SecurityException(
                "Email address is already in use.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getRole() == null) {
            user.setRole(UserRole.ROLE_DEFAULT.getName());
        }

        userRepository.save(user);

        return getJwtAuthenticationResponse(user);
    }

    public JwtAuthenticationResponse signIn(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new SecurityException(
                                "Invalid email/password.", HttpStatus.UNPROCESSABLE_ENTITY
                        ));

        return getJwtAuthenticationResponse(user);
    }

    private JwtAuthenticationResponse getJwtAuthenticationResponse(User user) {
        String token = jwtService.generateToken(user);

        return new JwtAuthenticationResponse(token);
    }

    private UUID getUUIDFromString(String userId) {
        return UUID.fromString(userId);
    }

}
