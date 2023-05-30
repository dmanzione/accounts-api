package com.binary_beasts.binary_banking.accounts_api.service;

import com.binary_beasts.binary_banking.accounts_api.exception.UserNotFoundException;
import com.binary_beasts.binary_banking.accounts_api.model.Customer;
import com.binary_beasts.binary_banking.accounts_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer retrieveCustomerInformation(Long pk) {
        return customerRepository.findById(pk).orElseThrow(()->new UserNotFoundException("No such customer in the system"));
    }
}
