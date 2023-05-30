package com.binary_beasts.binary_banking.accounts_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rewards")
public class Reward extends FinancialProduct {




    @NotNull
    @Column(name = "reward_balance", nullable = false)
    private Long rewardBalance;

}