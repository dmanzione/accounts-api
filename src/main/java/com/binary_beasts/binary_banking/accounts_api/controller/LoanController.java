package com.binary_beasts.binary_banking.accounts_api.controller;

import com.binary_beasts.binary_banking.accounts_api.dto.LoanDto;
import com.binary_beasts.binary_banking.accounts_api.model.Loan;
import com.binary_beasts.binary_banking.accounts_api.service.LoanService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts-api/loans")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Loan postLoan(@RequestBody LoanDto loanDto){

        return loanService.createLoan(loanDto);

    }

    @PutMapping({"{loanId}","{loanId}/"})
    @ResponseStatus(HttpStatus.OK)
    public Loan putLoan(@PathParam("loanId") Long loanId,@RequestBody Loan loan){
        return loanService.updateLoan(loanId, loan);
    }

}
