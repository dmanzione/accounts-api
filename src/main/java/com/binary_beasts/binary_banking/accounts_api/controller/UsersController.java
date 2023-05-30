package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.model.*;
import com.binary_beasts.binary_banking.accounts_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts-api/users")
@CrossOrigin
@Validated
public class UsersController {
    @Autowired
    AccountService accountService;




    @Autowired
    UserService userService;

    @GetMapping({"/",""})
    public List<User> getAllUsers(){
        return userService.retrieveAllUsers();
    }

    @GetMapping({"/{userPk}/accounts", "/{userPk}/accounts/"})
    public ResponseEntity<PagedModel<EntityModel<Account>>> getAllAccounts(@PathVariable Long userPk, PagedResourcesAssembler<Account> assembler) {
        return accountService.retrieveAllAccountsByUserId(userPk, assembler);
    }



}
