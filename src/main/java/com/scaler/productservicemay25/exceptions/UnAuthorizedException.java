package com.scaler.productservicemay25.exceptions;

public class UnAuthorizedException extends RuntimeException {
    private String message;

    public UnAuthorizedException(String message) {
        super(message);
    }
}
