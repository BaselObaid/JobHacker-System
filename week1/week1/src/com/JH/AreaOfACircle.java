
package com.JH;
import java.util.Scanner;
/*
*@BaselObaid
*/
public class AreaOfACircle {

    public static double calculateCArea(double r){
        double n = 3.14159;
        return n*(Math.pow(r,2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double R, A;
        R = input.nextDouble();
        A = calculateCArea(R);
        System.out.printf("A=%.4f\n", A);
        input.close();
    }


}