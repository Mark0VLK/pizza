package com.example.pizza.request.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record EmailAuthenticationRequest(

        @NotBlank(message = "{user.email.mandatory}")
        @Email(message = "{user.email.valid}")
        @Size(max = 50, message = "{user.email.size}")
        String email,

        @NotBlank(message = "{user.password.mandatory}")
        @Size(min = 8, max = 100, message = "{user.password.size}")
        String password
) {
}
