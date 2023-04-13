package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double [][] matrix = new double[12][12];
        int columnNumber;
        char sum = 'S', average = 'M', type;

        Scanner input = new Scanner(System.in);
        columnNumber = input.nextInt();
        type = input.next().charAt(0);
        fullMatrix(matrix,input);

        if (type==sum){
            System.out.printf("%.1f\n",calculateSum(matrix,columnNumber));
        }
        else if(type==average){
            System.out.printf("%.1f\n",calculateAvg(matrix,calculateSum(matrix,columnNumber)));
        }

    }

    public static void fullMatrix(double [][] matrix, Scanner input){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]= input.nextDouble();
            }
        }
    }

    public static double calculateSum(double [][] matrix, int columnNumber){
        double sumOfLine=0.0;
        for (int i = 0; i < matrix.length ; i++) {
            sumOfLine+=matrix[i][columnNumber];
        }
        return sumOfLine;
    }
    public static double calculateAvg(double [][] matrix,double sumOfColumn){
        double averageOfLine = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            averageOfLine = sumOfColumn / matrix.length;
        }
        return averageOfLine;
    }
}
