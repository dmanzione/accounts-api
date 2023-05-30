package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "financial_products")
public class FinancialProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    Long pk;

    @Column(name = "id")
    String id;

    @ManyToOne
    @JoinColumn(name = "account_pk")
    Account account;


    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;

    public FinancialProduct(String name) {
        this.name = name;
    }
}
