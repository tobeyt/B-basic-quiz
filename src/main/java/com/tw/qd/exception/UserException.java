package com.tw.qd.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserException extends RuntimeException {
    // TODO GTB-4: - 使用父类异常的message即可,不用重新定义
    private String message;
}
