package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;


public
interface UserRepository
        extends ListCrudRepository<User, Long>, ListPagingAndSortingRepository<User, Long> {
    List<User> findAllByRole(long l);

}