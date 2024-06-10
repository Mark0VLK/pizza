package com.example.pizza.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record DishCreateRequest(

        @NotNull(message = "{dish.numberOfPieces.mandatory}")
        @Min(value = 1, message = "{dish.numberOfPieces.min}")
        Integer numberOfPieces,

        @NotNull(message = "{dish.weight.mandatory}")
        @Positive(message = "{dish.weight.positive}")
        Double weight,

        @NotNull(message = "{dish.price.mandatory}")
        @Positive(message = "{dish.price.positive}")
        Double price,

        @NotNull(message = "{dish.informationId.mandatory}")
        Long informationId
) {}

