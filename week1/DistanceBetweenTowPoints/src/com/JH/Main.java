package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner p1 = new Scanner(System.in);

        System.out.printf("%.4f\n",distance(p1));
    }
    public static double distance(Scanner p1){

        double x1,y1,x2,y2,distance;

        x1 = p1.nextDouble();
        y1 = p1.nextDouble();
        x2 = p1.nextDouble();
        y2 = p1.nextDouble();

        distance = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        return distance;
    }

}
