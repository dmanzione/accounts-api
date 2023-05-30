package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.AccountDto;
import com.binary_beasts.binary_banking.accounts_api.dto.LoanDto;
import com.binary_beasts.binary_banking.accounts_api.model.Account;
import com.binary_beasts.binary_banking.accounts_api.model.Loan;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T11:45:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Loan toEntity(LoanDto loanDto) {
        if ( loanDto == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setPk( loanDto.getPk() );
        loan.setId( loanDto.getId() );
        loan.setAccount( accountMapper.toEntity( loanDto.getAccount() ) );
        loan.setName( loanDto.getName() );
        loan.setDescription( loanDto.getDescription() );
        loan.setInterestRate( loanDto.getInterestRate() );
        loan.setTermInMonths( loanDto.getTermInMonths() );
        loan.setPrincipalAmount( loanDto.getPrincipalAmount() );
        loan.setNumberOfPaymentsMade( loanDto.getNumberOfPaymentsMade() );
        loan.setMonthlyPayment( loanDto.getMonthlyPayment() );
        loan.setTotalInterestPaid( loanDto.getTotalInterestPaid() );
        loan.setRemainingBalance( loanDto.getRemainingBalance() );

        return loan;
    }

    @Override
    public LoanDto toDto(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        Long pk = null;
        String id = null;
        AccountDto account = null;
        String name = null;
        String description = null;
        Double interestRate = null;
        Short termInMonths = null;
        Double principalAmount = null;
        Short numberOfPaymentsMade = null;
        Double monthlyPayment = null;
        Double totalInterestPaid = null;
        Double remainingBalance = null;

        pk = loan.getPk();
        id = loan.getId();
        account = accountMapper.toDto( loan.getAccount() );
        name = loan.getName();
        description = loan.getDescription();
        interestRate = loan.getInterestRate();
        termInMonths = loan.getTermInMonths();
        principalAmount = loan.getPrincipalAmount();
        numberOfPaymentsMade = loan.getNumberOfPaymentsMade();
        monthlyPayment = loan.getMonthlyPayment();
        totalInterestPaid = loan.getTotalInterestPaid();
        remainingBalance = loan.getRemainingBalance();

        LoanDto loanDto = new LoanDto( pk, id, account, name, description, interestRate, termInMonths, principalAmount, numberOfPaymentsMade, monthlyPayment, totalInterestPaid, remainingBalance );

        return loanDto;
    }

    @Override
    public Loan partialUpdate(LoanDto loanDto, Loan loan) {
        if ( loanDto == null ) {
            return loan;
        }

        if ( loanDto.getPk() != null ) {
            loan.setPk( loanDto.getPk() );
        }
        if ( loanDto.getId() != null ) {
            loan.setId( loanDto.getId() );
        }
        if ( loanDto.getAccount() != null ) {
            if ( loan.getAccount() == null ) {
                loan.setAccount( new Account() );
            }
            accountMapper.partialUpdate( loanDto.getAccount(), loan.getAccount() );
        }
        if ( loanDto.getName() != null ) {
            loan.setName( loanDto.getName() );
        }
        if ( loanDto.getDescription() != null ) {
            loan.setDescription( loanDto.getDescription() );
        }
        if ( loanDto.getInterestRate() != null ) {
            loan.setInterestRate( loanDto.getInterestRate() );
        }
        if ( loanDto.getTermInMonths() != null ) {
            loan.setTermInMonths( loanDto.getTermInMonths() );
        }
        if ( loanDto.getPrincipalAmount() != null ) {
            loan.setPrincipalAmount( loanDto.getPrincipalAmount() );
        }
        if ( loanDto.getNumberOfPaymentsMade() != null ) {
            loan.setNumberOfPaymentsMade( loanDto.getNumberOfPaymentsMade() );
        }
        if ( loanDto.getMonthlyPayment() != null ) {
            loan.setMonthlyPayment( loanDto.getMonthlyPayment() );
        }
        if ( loanDto.getTotalInterestPaid() != null ) {
            loan.setTotalInterestPaid( loanDto.getTotalInterestPaid() );
        }
        if ( loanDto.getRemainingBalance() != null ) {
            loan.setRemainingBalance( loanDto.getRemainingBalance() );
        }

        return loan;
    }
}
