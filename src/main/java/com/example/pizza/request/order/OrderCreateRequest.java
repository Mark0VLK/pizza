package com.example.pizza.request.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class OrderCreateRequest {

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Location ID is mandatory")
    private Long locationId;
}
