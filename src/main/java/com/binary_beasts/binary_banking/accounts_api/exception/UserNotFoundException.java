package com.binary_beasts.binary_banking.accounts_api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
        printStackTrace();
    }
}
