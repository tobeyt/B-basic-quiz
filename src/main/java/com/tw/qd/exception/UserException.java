package com.tw.qd.exception;


public class UserException extends RuntimeException {
    // TODO GTB-4: - 使用父类异常的message即可,不用重新定义
    public UserException(String message) {
        super(message);
    }
}
