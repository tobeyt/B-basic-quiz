package com.tw.qd.exception;

import com.tw.qd.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handle(UserException exception) {
        return new Error(Instant.now().toString(), HttpStatus.NOT_FOUND.value(), "404 NOT FOUND",
                exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(MethodArgumentNotValidException exception) {
        return new Error(Instant.now().toString(), HttpStatus.BAD_REQUEST.value(), "400 BAD REQUEST",
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
