package com.example.pizza.enums.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationErrorCodes {

    FATAL_ERROR(1),
    ENTITY_NOT_FOUND_ERROR(4);

    private final int codeId;
}
