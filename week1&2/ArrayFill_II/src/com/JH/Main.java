package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int t;
        int [] vector = new int[1000];

        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for(int i = 0; i < vector.length; i++ ){
            vector[i] = i % t;
        }

        for (int i = 0; i < vector.length; i++) {
            System.out.println("N["+i+"] = " + vector[i]);
        }
    }
}
