package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card extends FinancialProduct{


    @Column(name = "date_created")
    private Instant dateCreated;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"user\"", nullable = false)
    private User user;

    @NotNull
    @Column(name = "cardholder_name", nullable = false, length = Integer.MAX_VALUE)
    private String cardholderName;

    @NotNull
    @Column(name = "card_number", nullable = false, length = Integer.MAX_VALUE)
    private String cardNumber;

  @Column(name = "status", columnDefinition = "card_status not null")
    private Object status;

}