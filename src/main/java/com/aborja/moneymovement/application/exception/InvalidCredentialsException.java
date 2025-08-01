package com.aborja.moneymovement.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
        super("Invalid username or password");
        log.error("message={}", "Invalid username or password");
    }

}
