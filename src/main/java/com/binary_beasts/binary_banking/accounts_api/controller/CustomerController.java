package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.model.Customer;
import com.binary_beasts.binary_banking.accounts_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts-api/customers")
@CrossOrigin("*")
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/",""})
    List<Customer> getAllCustomers() {
        return customerService.retrieveAllCustomers();
    }

    @GetMapping({"/{pk}","/{pk}/"})
    @ResponseStatus(HttpStatus.OK)
    Customer getCustomerByPk(Long pk){
        return customerService.retrieveCustomerInformation(pk);
    }
}
