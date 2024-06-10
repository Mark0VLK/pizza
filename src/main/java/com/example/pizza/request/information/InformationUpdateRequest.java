package com.example.pizza.request.information;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class InformationUpdateRequest extends InformationCreateRequest {

    @NotNull(message = "ID is mandatory")
    private Long id;
}
