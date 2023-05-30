package com.binary_beasts.binary_banking.accounts_api.repository;

import com.binary_beasts.binary_banking.accounts_api.model.Loan;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends ListCrudRepository<Loan, Long> {

}
