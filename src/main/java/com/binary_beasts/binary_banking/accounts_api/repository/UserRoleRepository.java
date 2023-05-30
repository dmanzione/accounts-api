package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.UserRole;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;


public
interface UserRoleRepository
        extends ListCrudRepository<UserRole, Long>, ListPagingAndSortingRepository<UserRole, Long> {
}