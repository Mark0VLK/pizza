package com.example.pizza.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record LocationCreateRequest(

        @NotBlank(message = "{location.country.mandatory}")
        @Size(max = 30, message = "{location.country.size}")
        String country,

        @NotBlank(message = "{location.city.mandatory}")
        @Size(max = 40, message = "{location.city.size}")
        String city,

        @NotBlank(message = "{location.street.mandatory}")
        @Size(max = 30, message = "{location.street.size}")
        String street,

        @NotBlank(message = "{location.house.mandatory}")
        @Size(max = 10, message = "{location.house.size}")
        String house,

        Integer floor,

        @Size(max = 10, message = "{location.flat.size}")
        String flat
) {
}