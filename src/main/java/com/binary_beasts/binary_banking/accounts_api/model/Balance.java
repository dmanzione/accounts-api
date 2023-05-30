package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Balance extends FinancialProduct {

    private Double amount;
    public Balance(){
        super("Balance");

    }

}
