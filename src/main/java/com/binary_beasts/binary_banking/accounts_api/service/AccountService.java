package com.binary_beasts.binary_banking.accounts_api.service;

import com.binary_beasts.binary_banking.accounts_api.dto.AccountDto;
import com.binary_beasts.binary_banking.accounts_api.exception.AccountNotFoundException;
import com.binary_beasts.binary_banking.accounts_api.exception.AccountOperationUnsuccessfulException;
import com.binary_beasts.binary_banking.accounts_api.mapper.*;
import com.binary_beasts.binary_banking.accounts_api.model.*;
import com.binary_beasts.binary_banking.accounts_api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;



    public Account openAccount(Account account) {




        return accountRepository.save(account);

    }

    public AccountDto makeChangesToAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        if (!accountRepository.existsById(account.getPk())) {
            throw new AccountNotFoundException("Cannot make changes to account because account with provided primary key is not in the system");
        }





        return accountMapper.toDto(accountRepository.save(account));

    }

    public void closeAccount(long pk) {
        Account account;
        if (!accountRepository.existsById(pk)) {
            throw new AccountNotFoundException("Cannot delete account because account with provided primary key is not in the system");
        } else {
            account = accountRepository.findAccountByPk(pk).orElseThrow();
        }



        accountRepository.delete(account);


    }

    public boolean existsById(long pk) {
        return accountRepository.existsById(pk);
    }

    public AccountDto findAccountWithAccountPK(Long primaryKey) {

        return accountMapper.toDto(accountRepository
                .findById(primaryKey)
                .orElseThrow(AccountNotFoundException::new));
    }

    public ResponseEntity<Page<Account>> retrieveAllAccounts(Integer page, PagedResourcesAssembler<Account> assembler) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("dateCreated").ascending());
        Page<Account> accountPage = accountRepository.findAll(pageable);


        return ResponseEntity.ok(accountPage);
    }

    public ResponseEntity<Page<Account>> retrieveAllAccounts(PagedResourcesAssembler<Account> assembler) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("dateCreated").ascending());
        Page<Account> accountPage = accountRepository.findAll(pageable);


        return ResponseEntity.ok(accountPage);
    }

    public ResponseEntity<PagedModel<EntityModel<Account>>> retrieveAllAccountsByUserId(Long userId, PagedResourcesAssembler<Account> assembler) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("dateCreated").ascending());
        Page<Account> accountPage = accountRepository.findByCustomer(userId, pageable);

        // Convert the page of accounts to a page of DTOs
        Page<AccountDto> accountDtoPage = accountPage.map(accountMapper::toDto);

        // Use the PagedResourcesAssembler to add next links to the response
        PagedModel<EntityModel<Account>> pagedModel = assembler.toModel(accountPage);

        return ResponseEntity.ok(pagedModel);
    }




    public Account retrieveAccountByPk(Long pk) {
        return accountRepository.findAccountByPk(pk).orElseThrow(() -> new AccountNotFoundException("No account exists with that primary key"));
    }

    public Account makeChangesToAccount(Long pk, Account account) {

        if (!accountRepository.existsById(pk)) {
            throw new AccountNotFoundException("Cannot delete account because account with provided primary key is not in the system");
        } else {
            account = accountRepository.findAccountByPk(pk).orElseThrow();
        }
        account = accountRepository.save(account);
        return account;
    };

    public List<Account> retrieveAllAccounts() {
        return accountRepository.findAll();
    }


}
