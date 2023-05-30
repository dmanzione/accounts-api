package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long pk;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "street_1", nullable = false, length = Integer.MAX_VALUE)
    private String street1;

    @Column(name = "street_2", length = Integer.MAX_VALUE)
    private String street2;

    @NotNull
    @Column(name = "city", nullable = false, length = Integer.MAX_VALUE)
    private String city;

    @Size(max = 2)
    @NotNull
    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Size(max = 10)
    @NotNull
    @Column(name = "zip", nullable = false, length = 10)
    private String zip;

}