package com.example.pizza.response;

import java.sql.Timestamp;

public record UserResponse(

        String name,

        String surname,

        String phoneNumber,

        String email,

        Timestamp birthDate
) {
}
