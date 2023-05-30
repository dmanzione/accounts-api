package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.exception.InsufficientFundsException;
import com.binary_beasts.binary_banking.accounts_api.exception.InvalidTransactionTypeException;
import com.binary_beasts.binary_banking.accounts_api.exception.InvalidTransactionException;
import com.binary_beasts.binary_banking.accounts_api.model.Account;
import com.binary_beasts.binary_banking.accounts_api.model.Transaction;
import com.binary_beasts.binary_banking.accounts_api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts-api/transactions")
@CrossOrigin(origins="*")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping({"","/"})
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        return ResponseEntity.ok(transaction);
    }

    @PostMapping({"/",""})
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        Account fromAccount = transaction.getFromAccount();
        Account toAccount = transaction.getToAccount();
        if(transaction.getCategory().name().equals("TRANSFER"))
        {
            if(fromAccount==null || toAccount ==null){
                throw new InvalidTransactionException("One of the accounts is not valid");
            }else
            if(fromAccount.getBalance()>=transaction.getAmount()){
                fromAccount.setBalance(fromAccount.getBalance()-transaction.getAmount());
                toAccount.setBalance(toAccount.getBalance()+transaction.getAmount());
            }else {
                throw new InsufficientFundsException();
            }

        }else if(transaction.getCategory().name().equals("DEPOSIT")){
            if(transaction.getToAccount()==null){
                throw new InvalidTransactionException("The account information provided is invalid");
            }else {
                toAccount.setBalance(toAccount.getBalance()+transaction.getAmount());
            }

        }else if(transaction.getCategory().name().equals("WITHDRAWAL")){
            if(transaction.getFromAccount()==null){
                throw new InvalidTransactionException("The account information provided is invalid");
            }else if(fromAccount.getBalance() < transaction.getAmount()) {
                throw new InsufficientFundsException();
            }else {
                fromAccount.setBalance(fromAccount.getBalance()- transaction.getAmount());
            }

        }else {
            throw new InvalidTransactionTypeException();
        }
        return transactionRepository.save(transaction);
    }



}
