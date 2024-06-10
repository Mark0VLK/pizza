package com.example.pizza.request.location;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class LocationUpdateRequest extends LocationCreateRequest {

    @NotNull(message = "ID is mandatory")
    Long id;
}
