package com.example.pizza.secure.service;


import com.example.pizza.enums.secure.TokenType;
import com.example.pizza.exception.UserNotFoundException;
import com.example.pizza.model.Token;
import com.example.pizza.model.User;
import com.example.pizza.repositories.TokenRepository;
import com.example.pizza.repositories.UserRepository;
import com.example.pizza.request.authentication.EmailAuthenticationRequest;
import com.example.pizza.request.authentication.LoginAuthenticationRequest;
import com.example.pizza.request.user.UserRegisterRequest;
import com.example.pizza.response.AuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserRegisterRequest registerRequest) {

        var user = User.builder()
                .name(registerRequest.name())
                .surname(registerRequest.surname())
                .phoneNumber(registerRequest.phoneNumber())
                .email(registerRequest.email())
                .login(registerRequest.login())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(registerRequest.role())
                .birthDate(registerRequest.birthDate())
                .isDeleted(false)
                .build();

        userRepository.save(user);

        var savedUser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticateForEmail(EmailAuthenticationRequest emailAuthenticationRequest) {

        final String email = emailAuthenticationRequest.email();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        emailAuthenticationRequest.password()
                )
        );
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with email: %s", email)));

        return generateAuthenticationResponse(user);
    }

    public AuthenticationResponse authenticateForLogin(LoginAuthenticationRequest loginAuthenticationRequest) {

        final String login = loginAuthenticationRequest.login();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        loginAuthenticationRequest.password()
                )
        );
        var user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with login: %s", login)));

        return generateAuthenticationResponse(user);
    }

    private AuthenticationResponse generateAuthenticationResponse(User user) {
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserToken = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validUserToken.isEmpty())
            return;
        validUserToken.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail).orElseThrow(() ->
                    new UserNotFoundException(String.format("User not found with email: %s", userEmail)));

            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);

                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);

                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
