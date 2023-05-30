package com.binary_beasts.binary_banking.accounts_api.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class InterestRate extends FinancialProduct {

    private Double interestRate;

    public InterestRate(){
        super();
        super.name = "Interest Rate";

    }

}
