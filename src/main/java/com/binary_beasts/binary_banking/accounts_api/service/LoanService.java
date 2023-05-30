package com.binary_beasts.binary_banking.accounts_api.service;


import com.binary_beasts.binary_banking.accounts_api.dto.LoanDto;
import com.binary_beasts.binary_banking.accounts_api.exception.NoSuchLoanException;
import com.binary_beasts.binary_banking.accounts_api.mapper.LoanMapper;
import com.binary_beasts.binary_banking.accounts_api.model.Loan;
import com.binary_beasts.binary_banking.accounts_api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanMapper loanMapper;

    public Loan createLoan(LoanDto loanDto) {
        Loan loan = loanMapper.toEntity(loanDto);
        loan = calculateMonthlyPayments(loan);
        loan = calculateTotalInterestPaid(loan);
        loan = calculateRemainingBalance(loan);
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long loanId, Loan loan) {
        if (!loanRepository.existsById(loanId)) {
            throw new NoSuchLoanException();
        }
        loan = calculateMonthlyPayments(loan);
        loan = calculateTotalInterestPaid(loan);
        loan = calculateRemainingBalance(loan);
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new NoSuchLoanException();
        }
        loanRepository.deleteById(id);

    }

    private Loan calculateRemainingBalance(Loan loan) {
        Double remainingBalance = loan.getPrincipalAmount() * Math.pow(1 + (loan.getInterestRate() / 12), loan.getNumberOfPaymentsMade()) -
                (loan.getMonthlyPayment() / (loan.getInterestRate() / 12)) * (Math.pow(1 + loan.getInterestRate() / 12, loan.getNumberOfPaymentsMade()) - 1);

        /*
        based on formula
        principalAmount * (1 + interestRate / 12)^n - (monthlyPayment / (interestRate / 12)) * ((1 + interestRate / 12)^n - 1)
         */

        loan.setRemainingBalance(remainingBalance);
        return loan;
    }

    private Loan calculateTotalInterestPaid(Loan loan) {
        Double totalInterestPaid = (loan.getMonthlyPayment() * loan.getTermInMonths()) - loan.getPrincipalAmount();
        loan.setTotalInterestPaid(totalInterestPaid);
        return loan;

        //based on formula totalInterest = (monthlyPayment * termInMonths) - principalAmount
    }

    private Loan calculateMonthlyPayments(Loan loan) {

        double monthlyPayment = (loan.getInterestRate() / 12) * loan.getPrincipalAmount() /
        1 - Math.pow(1 + (loan.getInterestRate() / 12), loan.getTermInMonths());
        //based on formula:  (interestRate / 12) * principalAmount / (1 - (1 + interestRate / 12)^(-termInMonths))
        loan.setMonthlyPayment(monthlyPayment);


        return loan;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
