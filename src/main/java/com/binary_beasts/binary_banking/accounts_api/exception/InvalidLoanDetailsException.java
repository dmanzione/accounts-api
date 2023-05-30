package com.binary_beasts.binary_banking.accounts_api.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class InvalidLoanDetailsException extends RuntimeException {
    public InvalidLoanDetailsException(List<ObjectError> allErrors) {
        super("Loan details are invalid.");
        allErrors.forEach(error -> System.out.println(error.getDefaultMessage()));
    }
}
