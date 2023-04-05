package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            double A, B, C;
            // inputs for grade
            A = input.nextDouble();
            B = input.nextDouble();
            C = input.nextDouble();

            System.out.printf("MEDIA = %.1f\n", average(A,B,C));
            input.close();
        }
        // to take the student's grade and return the average
        public static double average(double a, double b, double c){
            double weightA, weightB, weightC;
            weightA = 2.0;
            weightB = 3.0;
            weightC = 5.0;
            return((a*weightA + b*weightB + c*weightC)/(weightA+weightB+weightC));
        }
}
