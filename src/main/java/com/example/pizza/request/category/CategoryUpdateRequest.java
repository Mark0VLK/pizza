package com.example.pizza.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class CategoryUpdateRequest extends CategoryCreateRequest {

    @NotNull(message = "ID is mandatory")
    private Long id;
}
