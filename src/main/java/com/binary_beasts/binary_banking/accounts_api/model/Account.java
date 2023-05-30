package com.binary_beasts.binary_banking.accounts_api.model;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.*;

@Getter
@Setter
@Entity

@ToString
@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long pk;


    @Column(name = "number", nullable = false, length = Integer.MAX_VALUE, updatable = false)

    private String number;



    @JoinColumn(name = "customer", nullable = false)
    @ManyToOne
    private User customer;

    Boolean deleted = false;
    public Account(Long pk, String number, User customer, Instant dateCreated, Double balance,  AccountStatus status, AccountType type, User bankAgent) {
        this.pk = pk;
        this.number = "A-" + UUID.randomUUID().toString();
        this.customer = customer;
        this.dateCreated = dateCreated;
        this.balance = balance;

        this.status = status;
        this.type = type;
        this.bankAgent = bankAgent;

    }
    public Account(){
        this.number= "A-" + UUID.randomUUID().toString();
    }

    @Column(name = "date_created")
    private Instant dateCreated = Instant.now();

    @Column(name = "balance")
    private Double balance;

    @OneToMany(mappedBy = "account")
    List<FinancialProduct> financialProducts;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "account_status", name = "status")
    @Type(PostgreSQLEnumType.class)
    private AccountStatus status = AccountStatus.OPEN;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "account_type", name = "type")
    @Type(PostgreSQLEnumType.class)
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_agent", nullable = false)
    private User bankAgent;





    @Override
    public boolean equals(Object obj) {


        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Account acct = (Account) obj;

        return  this.status.equals(acct.status) && this.type.equals(acct.type) &&
                this.balance.equals(acct.balance) && this.dateCreated.equals(acct.dateCreated) && this.customer.equals(acct.customer);
    }


}