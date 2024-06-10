package com.example.pizza.request.drink;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class DrinkUpdateRequest extends DrinkCreateRequest {

    private Long id;
}
