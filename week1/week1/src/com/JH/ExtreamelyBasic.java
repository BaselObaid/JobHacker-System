package com.JH;

import java.util.Scanner;

        /*
         *@BaselObaid
         */

public class ExtreamelyBasic {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int A,B,X;
        A = input.nextInt();
        B = input.nextInt();
        X = sum(A,B);
        System.out.println("X = " + X);
        Math.pow(2,3);
    }


    public static int sum(int a, int b){
        return a+b;
    }
}
