package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "pk", nullable = false)
    private Long id;

    @Column(name = "user")
    private Long user;

}