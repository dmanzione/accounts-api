package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class OverdraftProtection extends FinancialProduct {

    private Double overdraftLimit;
    public OverdraftProtection(){
        super();
        this.name = "Overdraft Protection";
    }
}
