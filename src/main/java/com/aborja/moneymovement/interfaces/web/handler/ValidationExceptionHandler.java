package com.aborja.moneymovement.interfaces.web.handler;

import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.shared.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class ValidationExceptionHandler {

    private final static String VALIDATION_ERROR_MESSAGE = "Validation error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<ErrorDetails> handleValidationErrors(MethodArgumentNotValidException ex) {
        final var errorDetails = ErrorDetails.builder()
            .errors(new ArrayList<>())
            .message(VALIDATION_ERROR_MESSAGE)
            .build();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorDetails.addError(new ErrorDetails.Error(error.getField(), error.getDefaultMessage()));
        });
        
        return ApiResponse.badRequest(errorDetails);
    }
    
}
