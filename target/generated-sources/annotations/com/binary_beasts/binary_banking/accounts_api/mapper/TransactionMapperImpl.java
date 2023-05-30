package com.binary_beasts.binary_banking.accounts_api.mapper;

import com.binary_beasts.binary_banking.accounts_api.dto.AccountDto;
import com.binary_beasts.binary_banking.accounts_api.dto.TransactionDto;
import com.binary_beasts.binary_banking.accounts_api.model.Transaction;
import com.binary_beasts.binary_banking.accounts_api.model.TransactionCategory;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T11:43:30-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Transaction toEntity(TransactionDto transactionDto) {
        if ( transactionDto == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( transactionDto.getId() );
        transaction.setDate( transactionDto.getDate() );
        transaction.setAmount( transactionDto.getAmount() );
        transaction.setFromAccount( accountMapper.toEntity( transactionDto.getFromAccount() ) );
        transaction.setToAccount( accountMapper.toEntity( transactionDto.getToAccount() ) );
        transaction.setCategory( transactionDto.getCategory() );

        return transaction;
    }

    @Override
    public TransactionDto toDto(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        Long id = null;
        Instant date = null;
        Double amount = null;
        AccountDto fromAccount = null;
        AccountDto toAccount = null;
        TransactionCategory category = null;

        id = transaction.getId();
        date = transaction.getDate();
        amount = transaction.getAmount();
        fromAccount = accountMapper.toDto( transaction.getFromAccount() );
        toAccount = accountMapper.toDto( transaction.getToAccount() );
        category = transaction.getCategory();

        TransactionDto transactionDto = new TransactionDto( id, date, amount, fromAccount, toAccount, category );

        return transactionDto;
    }
}
