package com.binary_beasts.binary_banking.accounts_api.controller;


import com.binary_beasts.binary_banking.accounts_api.model.FinancialProduct;
import com.binary_beasts.binary_banking.accounts_api.service.FinancialProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts-api/financial-products")
@CrossOrigin(origins = "*")
public class FinancialProductController {

    @Autowired
    FinancialProductService financialProductService;
    @GetMapping({"/",""})
    List<FinancialProduct> getAllProducts(){
        return financialProductService.getAll();

    }
}

