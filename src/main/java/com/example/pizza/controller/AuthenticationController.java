package com.example.pizza.controller;

import com.example.pizza.request.authentication.EmailAuthenticationRequest;
import com.example.pizza.request.authentication.LoginAuthenticationRequest;
import com.example.pizza.request.user.UserRegisterRequest;
import com.example.pizza.response.AuthenticationResponse;
import com.example.pizza.secure.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authentication/email")
    public ResponseEntity<AuthenticationResponse> authenticateByEmail(
            @RequestBody EmailAuthenticationRequest emailAuthenticationRequest) {
        return new ResponseEntity<>(
                authenticationService.authenticateForEmail(emailAuthenticationRequest),
                HttpStatus.OK);
    }

    @PostMapping("/authentication/login")
    public ResponseEntity<AuthenticationResponse> authenticateByLogin(
            @RequestBody LoginAuthenticationRequest loginAuthenticationRequest) {
        return new ResponseEntity<>(
                authenticationService.authenticateForLogin(loginAuthenticationRequest),
                HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }
}
