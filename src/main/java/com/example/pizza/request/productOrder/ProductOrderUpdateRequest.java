package com.example.pizza.request.productOrder;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class ProductOrderUpdateRequest extends ProductOrderCreateRequest {

    @NotNull(message = "ID is mandatory")
    Long id;
}
