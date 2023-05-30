package com.binary_beasts.binary_banking.accounts_api.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct}
 */
@Value
public class FinancialProductDto implements Serializable {
    Long id;
    String name;
    String description;
}