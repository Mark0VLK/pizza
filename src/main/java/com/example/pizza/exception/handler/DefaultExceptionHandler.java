package com.example.pizza.exception.handler;

import com.example.pizza.exception.EntityNotFoundException;
import com.example.pizza.response.ErrorMessage;
import com.example.pizza.util.RandomValuesGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.example.pizza.enums.exeption.ApplicationErrorCodes.ENTITY_NOT_FOUND_ERROR;
import static com.example.pizza.enums.exeption.ApplicationErrorCodes.FATAL_ERROR;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class DefaultExceptionHandler {

    private final RandomValuesGenerator generator;

    private String getExceptionId(Exception e) {
        String exceptionId = generator.uuidGenerator();
        log.error(String.format("%s : %s", exceptionId, e.getMessage()), e);
        return exceptionId;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleOtherException(Exception e) {

        return new ResponseEntity<>(
                new ErrorMessage(
                        getExceptionId(e),
                        FATAL_ERROR.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException e) {

        return new ResponseEntity<>(
                new ErrorMessage(
                        getExceptionId(e),
                        ENTITY_NOT_FOUND_ERROR.getCodeId(),
                        e.getMessage()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
