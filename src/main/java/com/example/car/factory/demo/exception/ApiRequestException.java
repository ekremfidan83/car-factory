package com.example.car.factory.demo.exception;

public class ApiRequestException extends RuntimeException {

    private static final long serialVersionUID = -8673737497949476865L;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
