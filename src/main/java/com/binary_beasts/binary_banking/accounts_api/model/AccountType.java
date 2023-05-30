package com.binary_beasts.binary_banking.accounts_api.model;

public enum AccountType {
    CHECKING("Checking"),
    SAVINGS("Savings"),

    CREDIT_CARD("Credit Card"),
    LOAN("Loan"),
    UNKNOWN("Unknown");
    private final String displayName;

    AccountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getAccountTypeInfo() {
        switch (this) {
            case CHECKING:
                return "A checking account is a type of deposit account that allows you to easily access your money for daily transactions.";
            case SAVINGS:
                return "A savings account is a type of deposit account that earns interest and is used to save money for the future.";
             case CREDIT_CARD:
                return "A credit account is a type of loan account that allows you to borrow money and pay it back over time with interest.";
            case LOAN:
                return "A loan account is a type of credit account that allows you to borrow a fixed amount of money and pay it back over time with interest.";
            default:
                return "";
        }
    }
}