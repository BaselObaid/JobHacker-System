package com.JH;

import java.time.LocalDate;

public class SavingAccount extends Account{

    private double interestRate;

    public SavingAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interestAmount = getBalance() * (interestRate/100);
        setBalance(getBalance()+interestAmount);
        System.out.println("Interest of $" + interestAmount + " credited to " + getAccountHolderName() + ". New balance: $" + getBalance());
    }
}

