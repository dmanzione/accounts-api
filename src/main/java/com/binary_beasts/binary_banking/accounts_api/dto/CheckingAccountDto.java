package com.binary_beasts.binary_banking.accounts_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * A DTO for the {@link CheckingAccount} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
@EqualsAndHashCode

public class CheckingAccountDto {


    @NotNull(message = "Account cannot be null")
    private AccountDto account;
}