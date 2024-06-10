package com.example.pizza.request.information;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;


@Data
@Validated
public class InformationCreateRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @Size(max = 200, message = "Description must be less than 200 characters")
    private String description;

    @PositiveOrZero(message = "Energy value must be zero or positive")
    private Double energyValue;

    @PositiveOrZero(message = "Proteins value must be zero or positive")
    private Double proteins;

    @PositiveOrZero(message = "Fat value must be zero or positive")
    private Double fat;

    @PositiveOrZero(message = "Carb value must be zero or positive")
    private Double carb;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;

    @NotBlank(message = "Image is mandatory")
    @Size(max = 100, message = "Image URL must be less than 100 characters")
    private String image;
}

