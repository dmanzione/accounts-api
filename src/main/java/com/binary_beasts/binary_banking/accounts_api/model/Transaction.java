package com.binary_beasts.binary_banking.accounts_api.model;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long id;

    @Column(name = "date")
    private Instant date;


    @Column(name = "amount", nullable = false)
    private Double amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account")
    private Account fromAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account")
    private Account toAccount;

    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    @Column(name = "category", columnDefinition = "transaction_type(0, 0)")
    private TransactionCategory category;



}