package com.example.pizza.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record DrinkCreateRequest(

        @NotNull(message = "{drink.volume.mandatory}")
        @Positive(message = "{drink.volume.positive}")
        Double volume,

        @NotNull(message = "{drink.price.mandatory}")
        @Positive(message = "{drink.price.positive}")
        Double price,

        @NotNull(message = "{drink.informationId.mandatory}")
        Long informationId
) {}
