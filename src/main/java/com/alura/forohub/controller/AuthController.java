package com.alura.forohub.controller;


import com.alura.forohub.dtos.request.LoginRequestDTO;
import com.alura.forohub.dtos.response.AuthResponseDTO;
import com.alura.forohub.services.AluraUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final AluraUserService aluraUserService;

    public AuthController(AluraUserService aluraUserService) {
        this.aluraUserService = aluraUserService;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO request
    ) {
        return ResponseEntity.ok(aluraUserService.login(request));
    }
}
