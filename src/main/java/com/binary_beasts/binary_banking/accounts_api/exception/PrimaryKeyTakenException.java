package com.binary_beasts.binary_banking.accounts_api.exception;

public class PrimaryKeyTakenException extends RuntimeException {
    public PrimaryKeyTakenException(String message) {
        super(message);
    }
}
