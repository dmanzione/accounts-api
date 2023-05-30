package com.binary_beasts.binary_banking.accounts_api.service;

import com.binary_beasts.binary_banking.accounts_api.exception.UserNotFoundException;
import com.binary_beasts.binary_banking.accounts_api.model.Employee;
import com.binary_beasts.binary_banking.accounts_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> retrieveAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee retrieveEmployeeInformation(Long pk) {
        return employeeRepository.findById(pk).orElseThrow(() -> new UserNotFoundException("Employee record not in the system"));
    }
}
