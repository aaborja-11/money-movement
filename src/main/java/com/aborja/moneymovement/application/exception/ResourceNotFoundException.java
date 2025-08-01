package com.aborja.moneymovement.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.UUID;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> resourceClass, UUID id) {
        super(String.format("%s not found", resourceClass.getSimpleName()));
        log.error("message={}, id={}", String.format("%s not found", resourceClass.getSimpleName()), id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
        log.error("message={}", message);
    }

}
