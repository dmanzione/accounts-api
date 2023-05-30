package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AddressRepository
        extends CrudRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {
}