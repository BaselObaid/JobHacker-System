package com.JH;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void withdraw(int accountNumber, double amount, String accountName) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.getAccountHolderName().equals(accountName)) {
                account.withdrawMoney(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void deposit(int accountNumber, double amount, String accountName) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.getAccountHolderName().equals(accountName)) {
                account.depositMoney(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void viewBalance(int accountNumber, String accountName) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.getAccountHolderName().equals(accountName)) {
                System.out.println(account.getAccountHolderName() + " (" + account.getAccountNumber() + "): $" + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }
}




