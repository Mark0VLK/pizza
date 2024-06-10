package com.example.pizza.request.drink;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record DrinkUpdateRequest(

        @NotNull(message = "{drink.volume.mandatory}")
        @Positive(message = "{drink.volume.positive}")
        Double volume,

        @NotNull(message = "{drink.price.mandatory}")
        @Positive(message = "{drink.price.positive}")
        Double price,

        @NotNull(message = "{drink.informationId.mandatory}")
        Long informationId
) {
}
