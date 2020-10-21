package com.tw.qd.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    String timestamp;
    Integer status;
    String error;
    String message;
}
