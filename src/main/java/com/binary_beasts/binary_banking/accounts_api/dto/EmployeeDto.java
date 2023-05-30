package com.binary_beasts.binary_banking.accounts_api.dto;

import com.binary_beasts.binary_banking.accounts_api.model.Employee;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Long id;
    Long user;
}