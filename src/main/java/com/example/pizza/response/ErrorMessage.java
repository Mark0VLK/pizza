package com.example.pizza.response;

public record ErrorMessage(

        String errorId,

        Integer errorCode,

        String errorMessage
) {
}
