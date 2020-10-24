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
        // TODO GTB-3: - 了解下HttpStatus.NOT_FOUND.getReasonPhrase()
        return new Error(Instant.now().toString(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(MethodArgumentNotValidException exception) {
        // TODO GTB-4: + 有考虑到方法返回值为null的情况并进行了处理
        return new Error(Instant.now().toString(), HttpStatus.BAD_REQUEST.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
