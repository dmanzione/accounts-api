package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.model.Employee;
import com.binary_beasts.binary_banking.accounts_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts-api/employees")
@CrossOrigin(origins="*")

public class EmployeesController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping({"","/"})
    List<Employee> getAllEmployees(){
        return employeeService.retrieveAllEmployees();
    }

    @GetMapping({"/{pk}","/{pk}/"})
    Employee getEmployeeByPk(@PathVariable("pk") Long pk){
        return employeeService.retrieveEmployeeInformation(pk);
    }
}
