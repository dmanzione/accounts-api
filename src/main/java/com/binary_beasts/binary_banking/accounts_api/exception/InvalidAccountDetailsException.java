package com.binary_beasts.binary_banking.accounts_api.exception;

import com.binary_beasts.binary_banking.accounts_api.dto.CheckingAccountDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.Set;

public class InvalidAccountDetailsException extends ConstraintViolationException {


    public InvalidAccountDetailsException(String message, Set<ConstraintViolation<CheckingAccountDto>> errors) {
        super(message, errors);
        for (ConstraintViolation<CheckingAccountDto> error : errors) {
            System.err.println(error.getMessage());
        }
    }

    public InvalidAccountDetailsException(Set<ConstraintViolation<CheckingAccountDto>> errors) {
        super("Invalid account details", errors);
        for (ConstraintViolation<CheckingAccountDto> error : errors) {
            System.err.println(error.getMessage());
        }
    }
}
