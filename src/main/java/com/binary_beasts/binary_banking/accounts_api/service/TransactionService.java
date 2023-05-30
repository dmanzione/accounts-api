package com.binary_beasts.binary_banking.accounts_api.service;


import com.binary_beasts.binary_banking.accounts_api.model.Transaction;
import com.binary_beasts.binary_banking.accounts_api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

   public List<Transaction> getAllTransactions(){
       return transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactionsByAccountPk(Long accountPk) {
       List<Transaction> transactionsFrom = transactionRepository.findByFromAccountPk(accountPk);
       List<Transaction> transactionsTo = transactionRepository.findByToAccountPk(accountPk);
       transactionsFrom.addAll(transactionsTo);
       return transactionsFrom;
    }
}
