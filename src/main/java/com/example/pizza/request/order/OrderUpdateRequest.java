package com.example.pizza.request.order;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record OrderUpdateRequest(

        @NotNull(message = "{order.userId.mandatory}")
        Long userId,

        @NotNull(message = "{order.locationId.mandatory}")
        Long locationId
) {
}
