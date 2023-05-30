package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface FinancialProductRepository extends ListCrudRepository<FinancialProduct, Long> {

    List<FinancialProduct> findByAccountPk(Long accountPk);
}