package com.binary_beasts.binary_banking.accounts_api.service;

import com.binary_beasts.binary_banking.accounts_api.model.User;
import com.binary_beasts.binary_banking.accounts_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


   public List<User> retrieveAllUsers(){
       return userRepository.findAll();
   }
}
