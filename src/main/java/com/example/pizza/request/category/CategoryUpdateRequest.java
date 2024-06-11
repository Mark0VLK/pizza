package com.example.pizza.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record CategoryUpdateRequest(

        @NotBlank(message = "{category.name.mandatory}")
        @Size(max = 50, message = "{category.name.size}")
        String name
) {
}