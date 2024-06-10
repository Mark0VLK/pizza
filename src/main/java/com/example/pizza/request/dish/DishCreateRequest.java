package com.example.pizza.request.dish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class DishCreateRequest {

    @NotNull(message = "Number of pieces is mandatory")
    @Min(value = 1, message = "Number of pieces must be at least 1")
    private Integer numberOfPieces;

    @NotNull(message = "Weight is mandatory")
    @Positive(message = "Weight must be positive")
    private Double weight;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Information ID is mandatory")
    private Long informationId;
}

