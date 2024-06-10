package com.example.pizza.request.pizza;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class PizzaUpdateRequest extends PizzaCreateRequest {

    @NotNull(message = "ID is mandatory")
    private Long id;
}
