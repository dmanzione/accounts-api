package com.binary_beasts.binary_banking.accounts_api.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException() {

    }
}
