package com.example.pizza.request.dish;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class DishUpdateRequest extends DishCreateRequest {

    @NotNull(message = "ID is mandatory")
    Long id;
}
