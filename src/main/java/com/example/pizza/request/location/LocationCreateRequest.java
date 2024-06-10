package com.example.pizza.request.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class LocationCreateRequest {

    @NotBlank(message = "Country is mandatory")
    @Size(max = 30, message = "Country must be less than 30 characters")
    private String country;

    @NotBlank(message = "City is mandatory")
    @Size(max = 40, message = "City must be less than 40 characters")
    private String city;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 30, message = "Street must be less than 30 characters")
    private String street;

    @NotBlank(message = "House is mandatory")
    @Size(max = 10, message = "House must be less than 10 characters")
    private String house;

    private Integer floor;

    @Size(max = 10, message = "Flat must be less than 10 characters")
    private String flat;
}
