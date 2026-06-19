package com.bruno.sistemaProdutos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.sistemaProdutos.dto.LoginRequestDto;
import com.bruno.sistemaProdutos.dto.RegisterRequestDto;
import com.bruno.sistemaProdutos.dto.TokenResponseDto;
import com.bruno.sistemaProdutos.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequestDto registerRequestDto) {
        authenticationService.register(registerRequestDto);
    }
    
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid LoginRequestDto loginRequestDto) throws Exception {
        return authenticationService.login(loginRequestDto);
    }
}
