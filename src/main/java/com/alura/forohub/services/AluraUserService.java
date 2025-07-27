package com.alura.forohub.services;

import com.alura.forohub.config.jwt.JwtService;
import com.alura.forohub.dtos.request.LoginRequestDTO;
import com.alura.forohub.dtos.response.AuthResponseDTO;
import com.alura.forohub.entities.AluraUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AluraUserService
{
    private final AluraUserRepository aluraUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AluraUserDetailsService aluraUserDetailsService;

    public AluraUserService(AluraUserRepository aluraUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, AluraUserDetailsService aluraUserDetailsService) {
        this.aluraUserRepository = aluraUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.aluraUserDetailsService = aluraUserDetailsService;
    }


    @Transactional
    public AuthResponseDTO login(LoginRequestDTO request)
    {
        // Authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Find user
        AluraUser aluraUser  = aluraUserRepository.findByEmail(request.getEmail());

        // Generate JWT
        String token = jwtService.generateToken(aluraUser.getEmail());

        return AuthResponseDTO.builder()
                .token(token)
                .email(aluraUser.getEmail())
                .build();
    }
}
