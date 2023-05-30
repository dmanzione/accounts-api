package com.binary_beasts.binary_banking.accounts_api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link CreditCardAccount} entity
 */
@Data
public class CreditCardAccountDto implements Serializable {

    private final AccountDto account;

}