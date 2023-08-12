package com.JH;

public class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(){

    }

    public Account(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn from " + accountHolderName + ". New balance: $" + balance);
        }
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited into " + accountHolderName + ". New balance: $" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}