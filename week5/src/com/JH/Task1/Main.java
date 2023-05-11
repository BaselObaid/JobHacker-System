package com.JH.Task1;
/*
 *@BaselObaid
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        int firstNumber, secondNumber, sum=0;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("please enter the first number: ");
                firstNumber = input.nextInt();
                System.out.println("please enter the second number: ");
                secondNumber = input.nextInt();
                sum = firstNumber + secondNumber;

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("invalid input please try again");
                input.nextLine();
                continue;
            }
                System.out.print("the sum of the two number is: " + sum);
                flag = false;

        }
    }

}
