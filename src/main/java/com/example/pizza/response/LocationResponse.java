package com.example.pizza.response;

public record LocationResponse(

        String country,

        String city,

        String street,

        String house,

        Integer floor,

        String flat
) {
}
