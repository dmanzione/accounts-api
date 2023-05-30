package com.binary_beasts.binary_banking.accounts_api.dto;

import com.binary_beasts.binary_banking.accounts_api.model.TransactionCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.binary_beasts.binary_banking.accounts_api.model.Transaction}
 */
@Value
public class TransactionDto implements Serializable {
    Long id;
    Instant date;

    Double amount;

    AccountDto fromAccount;
    AccountDto toAccount;

    TransactionCategory category;

}