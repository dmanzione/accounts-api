package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.model.Customer;
import com.binary_beasts.binary_banking.accounts_api.model.User;
import com.binary_beasts.binary_banking.accounts_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts-api/customers")
@CrossOrigin(origins="*")
@Validated
public class CustomerController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/",""})
    List<User> getAllCustomers() {
        return userService.retrieveAllCustomers();
    }

    @GetMapping({"/{pk}","/{pk}/"})
    @ResponseStatus(HttpStatus.OK)
    User getCustomerByPk(Long pk){
        return userService.retrieveAllCustomers().stream().filter(usr->usr.getPk().equals(pk)).toList().get(0);
    }
}
