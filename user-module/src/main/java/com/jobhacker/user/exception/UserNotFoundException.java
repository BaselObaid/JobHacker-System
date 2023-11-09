package com.jobhacker.user.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String exceptionMsg) {
        super(exceptionMsg);
    }
}
