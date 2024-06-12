package com.example.pizza.exception;

public class EntityNotFoundException extends jakarta.persistence.EntityNotFoundException {

    public EntityNotFoundException(String entity, Long id) {
        super(String.format("The %s with id %d not found", entity, id));
    }
}
