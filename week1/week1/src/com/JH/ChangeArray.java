package com.JH;

import java.util.Scanner;

/*
 *@BaselObaid
 */

public class ChangeArray {

    public static void main(String[] args) {

        int [] array = new int[20];
        fullArray(array);
        reverseArray(array);
        printArray(array);
    }

    //to full array by element
    public static void fullArray(int [] array){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i]=input.nextInt();
        }
    }

    //loop from 0 to the middle of an array and at the same time loop from the end to the middle
    public static void reverseArray(int[]array){
        for (int i = 0,j= array.length-1; i < (array.length/2)&&j>= (array.length/2) ; i++,j--) {
            array[i]=array[i]+array[j];
            array[j]=array[i]-array[j];
            array[i]=array[i]-array[j];
        }
    }

    public static void printArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("N["+i+"] = " + array[i]);
        }
    }

}
