package com.JH;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bankAccounts = new Bank();
        Account a1 = new Account(123,"a", 0);
        Account a2 = new Account(124,"b", 0);
        Account a3 = new Account(125,"c", 0);
        Account a4 = new Account(126,"d", 0);
        Account a5 = new Account(127,"e", 0);

        bankAccounts.addAccount(a1);
        bankAccounts.addAccount(a2);
        bankAccounts.addAccount(a3);
        bankAccounts.addAccount(a4);
        bankAccounts.addAccount(a5);

        Scanner input = new Scanner(System.in);
        Scanner account = new Scanner(System.in);
        int number, accountNumber;
        double amount;
        String accountName;
        while(true){

            System.out.println("please enter your account name:");
            accountName = account.next();
            System.out.println("please enter your account number:");
            accountNumber = account.nextInt();

            System.out.println("hello, chose a process you want");
            System.out.println("enter 1-check balance.\t 2- withdraw.\t3- deposit.");
            number = input.nextInt();
            switch (number){
                case 1: bankAccounts.viewBalance(accountNumber,accountName);
                    break;
                case 2:
                    System.out.println("enter the amount");
                    amount = input.nextDouble();
                    bankAccounts.withdraw(accountNumber,amount,accountName);
                    break;
                case 3:
                    System.out.println("enter the amount");
                    amount = input.nextDouble();
                    bankAccounts.deposit(accountNumber,amount,accountName);
                    break;
                default:
                    System.out.println("not valid process");
                    break;
            }


        }
    }
}
