package com.example.pizza.request.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
public class UserUpdateRequest extends UserCreateRequest {

    @NotNull(message = "ID is mandatory")
    private Long id;
}
