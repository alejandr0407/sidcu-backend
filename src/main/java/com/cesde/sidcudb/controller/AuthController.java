package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.dto.request.LoginRequestDTO;
import com.cesde.sidcudb.dto.request.RegistroRequestDTO;
import com.cesde.sidcudb.dto.response.LoginResponseDTO;
import com.cesde.sidcudb.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registro")
    public ResponseEntity<LoginResponseDTO> registrar(
            @Valid @RequestBody RegistroRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authService.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}