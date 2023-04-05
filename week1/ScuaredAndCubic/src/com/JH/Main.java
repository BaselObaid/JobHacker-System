package com.JH;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number;
        Scanner input = new Scanner(System.in);
        number = input.nextInt();

        int [] arr = new int[number];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
            System.out.println(arr[i] + " " + (int)Math.pow(arr[i],2) + " " + (int)Math.pow(arr[i],3));
        }

    }
}
