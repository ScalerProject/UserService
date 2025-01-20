package com.scaler.userservicejan25.exceptions;

public class UserNotFoundException extends RuntimeException{
    private final String email;

    public UserNotFoundException(String email, String message) {
        super(message);
        this.email = email;
    }
}
