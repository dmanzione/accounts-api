package com.binary_beasts.binary_banking.accounts_api.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.binary_beasts.binary_banking.accounts_api.model.Loan}
 */
@Value
public class LoanDto implements Serializable {
    Long pk;
    String id;
    AccountDto account;
    String name;
    String description;
    Double interestRate;
    Short termInMonths;
    Double principalAmount;
    Short numberOfPaymentsMade;
    Double monthlyPayment;
    Double totalInterestPaid;
    Double remainingBalance;
}