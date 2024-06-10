package com.example.pizza.response;

public record InformationResponse(

        String name,

        String description,

        Double energyValue,

        Double proteins,

        Double fat,

        Double carb,

        Long categoryId,

        String image
) {
}
