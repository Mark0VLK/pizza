package com.example.pizza.response;

import lombok.Builder;

@Builder
public record DishOrderResponse(

        String name,

        String image,

        Integer quantity,

        Integer numberOfPieces,

        Double weight,

        Double price
) {
}
