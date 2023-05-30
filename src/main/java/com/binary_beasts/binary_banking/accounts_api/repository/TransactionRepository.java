package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {

    List<Transaction> findByFromAccountPk(Long accountPk);
    List<Transaction> findByToAccountPk(Long accountPk);
}