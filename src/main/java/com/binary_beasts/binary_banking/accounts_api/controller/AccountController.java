package com.binary_beasts.binary_banking.accounts_api.controller;


import com.binary_beasts.binary_banking.accounts_api.model.Account;
import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import com.binary_beasts.binary_banking.accounts_api.model.Transaction;
import com.binary_beasts.binary_banking.accounts_api.service.AccountService;
import com.binary_beasts.binary_banking.accounts_api.service.FinancialProductService;
import com.binary_beasts.binary_banking.accounts_api.service.TransactionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/accounts-api/accounts")
@CrossOrigin(origins={"*","http://localhost:3000/accounts/**","http://localhost:3000/accounts/*","**"})
@Validated
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    FinancialProductService financialProductService;
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Page<Account>> getAllAccounts(@RequestParam(name="size", required = false) Short size,@RequestParam(name = "page",required = false) Integer pageNum, PagedResourcesAssembler<Account> page) {
       if(page!=null)
        return accountService.retrieveAllAccounts(pageNum,page);
       else
           return accountService.retrieveAllAccounts(page);
    }

    @GetMapping({"/{accountId}/products","/{accountId}/products/"})
    List<FinancialProduct> getFinancialProducts(@PathParam("accountId") Long accountId){
        return financialProductService.getProductsByAccountPk(accountId);
    }
    @GetMapping("/accountslist")
    List<Account> getAllAccounts(){
        return accountService.retrieveAllAccounts();
    }
    @GetMapping({"/{accountId}/","/{accountId}"})
    @ResponseStatus(HttpStatus.OK)
    Account getAccountById(@PathVariable Long accountId){
        return accountService.retrieveAccountByPk(accountId);
    }
    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<EntityModel<Account>>> getAllAccountsByUserId(@PathVariable("userId") Long userId, PagedResourcesAssembler<Account> assembler) {
        return accountService.retrieveAllAccountsByUserId(userId, assembler);
    }

    @DeleteMapping({"/{pk}","/{pk}/"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long pk){
        accountService.closeAccount(pk);
    }

    @PutMapping({"/{pk}","/{pk}/"})
    @ResponseStatus(HttpStatus.OK)
    public Account modifyAccount(@PathVariable("pk") Long pk, @RequestBody Account account){
       return accountService.makeChangesToAccount(pk,account);
    }
    @PostMapping(
            path = {"", "/"},
            consumes = "application/json"
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Account postAccount(
            @RequestBody


            Account account
    ) {




        account = accountService.openAccount(account);
        System.out.println(account);
        return account;

    }

    @GetMapping({"/{accountId}/transactions","/{accountId}/transactions/"})
    List<Transaction> getAllAccountTransactions(@PathVariable("accountId") Long accountPk){
        return transactionService.getAllTransactionsByAccountPk(accountPk);
    }
}
