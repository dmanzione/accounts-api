package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.Optional;


public interface AccountRepository
        extends ListPagingAndSortingRepository<Account, Long>, ListCrudRepository<Account, Long> {


    Page<Account> findByCustomer(Long userId, Pageable pageable);

    Optional<Account> findAccountByPk(Long pk);


}