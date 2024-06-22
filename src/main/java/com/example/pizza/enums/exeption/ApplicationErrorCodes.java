package com.example.pizza.enums.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationErrorCodes {

    FATAL_ERROR(1),
    ENTITY_NOT_FOUND_ERROR(4),
    USER_NOT_FOUND_ERROR(6);

    private final int codeId;
}
