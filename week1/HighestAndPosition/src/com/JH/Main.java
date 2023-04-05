package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int [] array = new int[100];
        int highestNumber, highestPosition;
        takeArrayInputs(array);
        highestNumber = findTheHighestNumber(array);
        highestPosition = findTheHighestPosition(array);
        System.out.println(highestNumber + "\n" + highestPosition);
    }

    public static void takeArrayInputs(int [] array){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }

    public static int findTheHighestNumber(int [] array){
        int max=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public static int findTheHighestPosition(int [] array){
        int max=0;
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
                position = i+1;
            }
        }
        return position;
    }

}
