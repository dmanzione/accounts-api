package com.binary_beasts.binary_banking.accounts_api.dto;


import com.binary_beasts.binary_banking.accounts_api.model.Customer;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
@Value
public class CustomerDto implements Serializable {
    Long id;
    Long user;
}