package com.example.pizza.response;

public record OrderResponse(

        Long userId,

        Long locationId,

        Boolean delivered
) {
}
