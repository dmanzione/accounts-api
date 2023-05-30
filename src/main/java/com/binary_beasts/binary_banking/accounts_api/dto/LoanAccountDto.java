package com.binary_beasts.binary_banking.accounts_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link LoanAccount}
 */
@Value
public class LoanAccountDto implements Serializable {

    @NotNull
    AccountDto account;

    Long pk;


}