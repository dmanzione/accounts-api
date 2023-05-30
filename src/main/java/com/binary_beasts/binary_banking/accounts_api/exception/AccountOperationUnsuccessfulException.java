package com.binary_beasts.binary_banking.accounts_api.exception;

public class AccountOperationUnsuccessfulException extends RuntimeException {
    public AccountOperationUnsuccessfulException(String s) {
        super(s);
    }

    public AccountOperationUnsuccessfulException(String s, AccountNotFoundException e) {
        super(e);
        throw e;
    }
}
