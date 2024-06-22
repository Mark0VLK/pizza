package com.example.pizza.request.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record LoginAuthenticationRequest(

        @NotBlank(message = "{user.login.mandatory}")
        @Size(max = 20, message = "{user.login.size}")
        String login,

        @NotBlank(message = "{user.password.mandatory}")
        @Size(min = 8, max = 100, message = "{user.password.size}")
        String password) {
}
