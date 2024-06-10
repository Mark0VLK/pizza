package com.example.pizza.request.information;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


@Validated
public record InformationCreateRequest(

        @NotBlank(message = "{information.name.mandatory}")
        @Size(max = 50, message = "{information.name.size}")
        String name,

        @Size(max = 200, message = "{information.description.size}")
        String description,

        @PositiveOrZero(message = "{information.energyValue.positiveOrZero}")
        Double energyValue,

        @PositiveOrZero(message = "{information.proteins.positiveOrZero}")
        Double proteins,

        @PositiveOrZero(message = "{information.fat.positiveOrZero}")
        Double fat,

        @PositiveOrZero(message = "{information.carb.positiveOrZero}")
        Double carb,

        @NotNull(message = "{information.categoryId.mandatory}")
        Long categoryId,

        @NotBlank(message = "{information.image.mandatory}")
        @Size(max = 100, message = "{information.image.size}")
        String image
) {
}

