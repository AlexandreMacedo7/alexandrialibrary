package com.alexandre.alexandrialibrary.infra;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
