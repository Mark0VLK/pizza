package com.example.pizza.request.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record ProductOrderCreateRequest(

        @NotNull(message = "{productOrder.orderId.mandatory}")
        Long orderId,

        @NotNull(message = "{productOrder.productId.mandatory}")
        Long productId,

        @NotNull(message = "{productOrder.quantity.mandatory}")
        @Min(value = 1, message = "{productOrder.quantity.min}")
        Integer quantity
) {
}
