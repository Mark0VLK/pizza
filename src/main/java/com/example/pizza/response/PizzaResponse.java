package com.example.pizza.response;

public record PizzaResponse(

        Double diameter,

        Double weight,

        Double price,

        Long informationId
) {
}
