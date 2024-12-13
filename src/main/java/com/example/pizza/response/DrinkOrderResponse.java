package com.example.pizza.response;

import lombok.Builder;

@Builder
public record DrinkOrderResponse(

        String name,

        String image,

        Integer quantity,

        Double volume,

        Double price
) {
}
