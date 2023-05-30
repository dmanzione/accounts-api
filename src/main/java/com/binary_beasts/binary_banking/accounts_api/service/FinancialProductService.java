package com.binary_beasts.binary_banking.accounts_api.service;

import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import com.binary_beasts.binary_banking.accounts_api.repository.FinancialProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialProductService {

    @Autowired
    FinancialProductRepository financialProductRepository;

    public List<FinancialProduct> getProductsByAccountPk(Long accountId) {
        return financialProductRepository.findAll().stream().filter((prod)->prod.getAccount().getPk()==accountId).toList();
    }

    public List<FinancialProduct> getAll(){
        return financialProductRepository.findAll();
    }
}
