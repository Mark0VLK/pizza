package com.example.pizza.request.drink;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class DrinkCreateRequest {

    @NotNull(message = "Volume is mandatory")
    @Positive(message = "Volume must be positive")
    private Double volume;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Information ID is mandatory")
    private Long informationId;
}
