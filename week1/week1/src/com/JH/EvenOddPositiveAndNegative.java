package com.JH;

import java.util.Scanner;

        /*
         *@BaselObaid
         */

public class EvenOddPositiveAndNegative {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int [] num = new int[5];
        for(int i = 0; i< num.length;i++ ){
            num[i]= input.nextInt();
        }
        countOddAndEvenn(num);
        countPositiveAndNegative(num);

    }


    public static void countOddAndEvenn(int [] num){
        int countOdd=0,countEven=0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]%2==0) countEven++;
            else countOdd++;
        }
        System.out.println(countEven + " valor(es) par(es)\n" + countOdd + " valor(es) impar(es)");
    }
    public static void countPositiveAndNegative(int [] num){
        int countP=0, countN=0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]>0)countP++;
            else if(num[i]<0)countN++;
        }
        System.out.println(countP + " valor(es) positivo(s)\n" + countN + " valor(es) negativo(s)");
    }
}