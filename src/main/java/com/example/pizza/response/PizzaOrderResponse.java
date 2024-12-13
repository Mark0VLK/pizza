package com.example.pizza.response;

import lombok.Builder;

@Builder
public record PizzaOrderResponse(

        String name,

        String image,

        Integer quantity,

        Double diameter,

        Double weight,

        Double price
) {
}
