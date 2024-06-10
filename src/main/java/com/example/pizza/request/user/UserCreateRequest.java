package com.example.pizza.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Data
@Validated
public class UserCreateRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must be less than 20 characters")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(max = 50, message = "Surname must be less than 50 characters")
    private String surname;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    @Pattern(regexp = "^[+]?\\d{10,20}$", message = "Phone number is invalid")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 50, message = "Email must be less than 50 characters")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;

    @Past(message = "Birth date must be in the past")
    private Timestamp birthDate;
}
