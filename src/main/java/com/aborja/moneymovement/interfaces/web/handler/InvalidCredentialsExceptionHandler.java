package com.aborja.moneymovement.interfaces.web.handler;

import com.aborja.moneymovement.application.exception.InvalidCredentialsException;
import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.shared.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidCredentialsExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ApiResponse<ErrorDetails> handleValidationErrors(InvalidCredentialsException ex) {
        final var errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .build();

        return ApiResponse.unauthorized(errorDetails);
    }

}
