package com.aborja.moneymovement.interfaces.web.handler;

import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.shared.ErrorDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<ErrorDetails> handleValidationErrors(ResourceNotFoundException ex) {
        final var errorDetails = ErrorDetails.builder()
            .message(ex.getMessage())
            .build();
        
        return ApiResponse.notFound(errorDetails);
    }
    
}
