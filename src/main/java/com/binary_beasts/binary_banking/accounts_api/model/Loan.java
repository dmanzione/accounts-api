package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Loan extends FinancialProduct {



    public Loan(double interestRate, short termInMonths, double principalAmount){

        this.interestRate = interestRate;
        this.termInMonths = termInMonths;
        this.principalAmount = principalAmount;
        this.numberOfPaymentsMade = 0;

    }
    private Double interestRate;
    private Short termInMonths;
    private Double principalAmount;

    private Short numberOfPaymentsMade=0;


    //derived values
    private Double monthlyPayment;
    private Double totalInterestPaid;
    private Double remainingBalance;

//        private String loanType;

//        private String collateral;
//        private LocalDate originationDate;



}