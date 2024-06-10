package com.example.pizza.response;

public record DishResponse(

        Integer numberOfPieces,

        Double weight,

        Double price,

        Long informationId
) {
}
