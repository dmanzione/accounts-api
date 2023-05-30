package com.binary_beasts.binary_banking.accounts_api.dto;

import com.binary_beasts.binary_banking.accounts_api.model.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.binary_beasts.binary_banking.accounts_api.model.Card}
 */
@Value
public class CardDto implements Serializable {
    Long id;
    String name;
    String description;
    Instant dateCreated;
    @NotNull
    UserDto user;
    @NotNull
    Account account;
    @NotNull
    String cardholderName;
    @NotNull
    String cardNumber;
    Object status;
}