package com.psp.cm.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class CustomerException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus statusCode;

    public CustomerException(String message, HttpStatus statusCode) {
        super();
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
