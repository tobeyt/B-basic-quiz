package com.tw.qd.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserException extends RuntimeException {
    private String message;
}
