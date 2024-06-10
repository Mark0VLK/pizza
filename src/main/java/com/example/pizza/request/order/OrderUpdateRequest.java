package com.example.pizza.request.order;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class OrderUpdateRequest extends OrderCreateRequest {

    @NotNull(message = "ID is mandatory")
    Long id;
}
