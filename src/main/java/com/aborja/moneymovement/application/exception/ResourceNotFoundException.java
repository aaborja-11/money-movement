package com.aborja.moneymovement.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> resourceClass, UUID id) {
        super(String.format("%s not found: (id=%s)", resourceClass.getSimpleName(), id));
    }

}
