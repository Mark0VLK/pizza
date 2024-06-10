package com.example.pizza.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Validated
public record UserCreateRequest(

        @NotBlank(message = "{user.name.mandatory}")
        @Size(max = 20, message = "{user.name.size}")
        String name,

        @NotBlank(message = "{user.surname.mandatory}")
        @Size(max = 50, message = "{user.surname.size}")
        String surname,

        @NotBlank(message = "{user.phoneNumber.mandatory}")
        @Size(max = 20, message = "{user.phoneNumber.size}")
        @Pattern(regexp = "^[+]?\\d{10,20}$", message = "{user.phoneNumber.invalid}")
        String phoneNumber,

        @NotBlank(message = "{user.email.mandatory}")
        @Email(message = "{user.email.valid}")
        @Size(max = 50, message = "{user.email.size}")
        String email,

        @NotBlank(message = "{user.password.mandatory}")
        @Size(min = 8, max = 100, message = "{user.password.size}")
        String password,

        @Past(message = "{user.birthDate.past}")
        Timestamp birthDate
) {
}
