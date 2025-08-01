package com.aborja.moneymovement.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends ResourceNotFoundException {

    public AccountNotFoundException(Class<?> resourceClass, UUID id) {
        super(resourceClass, id);
    }

    public AccountNotFoundException(String username) {
        super("Account not found");
        log.error("message={}, username={}", "Account not found", username);
    }

}
