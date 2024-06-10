package com.example.pizza.request.pizza;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record PizzaCreateRequest(

        @NotNull(message = "{pizza.diameter.mandatory}")
        @Positive(message = "{pizza.diameter.positive}")
        Double diameter,

        @NotNull(message = "{pizza.weight.mandatory}")
        @Positive(message = "{pizza.weight.positive}")
        Double weight,

        @NotNull(message = "{pizza.price.mandatory}")
        @Positive(message = "{pizza.price.positive}")
        Double price,

        @NotNull(message = "{pizza.informationId.mandatory}")
        Long informationId
) {
}
