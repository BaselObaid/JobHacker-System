package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num;
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};
        System.out.println(num);
        for (int i = 0; i < banknotes.length; i++) {
            System.out.println(num / banknotes[i] + " nota(s) de R$ " + banknotes[i] + ",00");
            num = num % banknotes[i];
        }


    }


}
