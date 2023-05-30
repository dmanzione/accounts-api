package com.binary_beasts.binary_banking.accounts_api.dto;
import com.binary_beasts.binary_banking.accounts_api.model.AccountStatus;
import com.binary_beasts.binary_banking.accounts_api.model.AccountType;
import com.binary_beasts.binary_banking.accounts_api.model.Employee;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.binary_beasts.binary_banking.accounts_api.model.Account}
 */
@Value
public class AccountDto implements Serializable {
    Long pk;
    String number;
    Instant dateCreated;
    Double balance;

    AccountStatus status;
    AccountType type;

    UserDto
            bankAgent;
    UserDto customer;

}