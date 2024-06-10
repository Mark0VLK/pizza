package com.example.pizza.request.pizza;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class PizzaCreateRequest {

    @NotNull(message = "Diameter is mandatory")
    @Positive(message = "Diameter must be positive")
    private Double diameter;

    @NotNull(message = "Weight is mandatory")
    @Positive(message = "Weight must be positive")
    private Double weight;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Information ID is mandatory")
    private Long informationId;
}
