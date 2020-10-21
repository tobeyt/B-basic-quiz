package com.tw.qd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handle(UserException exception) {
        return new Error(Instant.now().toString(), HttpStatus.NOT_FOUND.value(), "404 NOT FOUND", exception.getMessage());
    }
}