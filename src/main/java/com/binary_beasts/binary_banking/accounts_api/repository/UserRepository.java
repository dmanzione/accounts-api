package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;


public
interface UserRepository
        extends ListCrudRepository<User, Long>, ListPagingAndSortingRepository<User, Long> {
}