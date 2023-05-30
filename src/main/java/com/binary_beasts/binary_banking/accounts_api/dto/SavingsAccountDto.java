package com.binary_beasts.binary_banking.accounts_api.dto;

import jakarta.validation.Valid;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link SavingsAccount} entity
 */
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class SavingsAccountDto implements Serializable {
    @Valid
    private final AccountDto account;
}