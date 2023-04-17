package com.JH;

import java.util.Scanner;

        /*
         *@BaselObaid
         */

public class LineInArray {

    public static void main(String[] args) {

        double [][] matrix = new double[12][12];
        int LineNumber;
        char sum = 'S', average = 'M', type;

        Scanner input = new Scanner(System.in);
        LineNumber = input.nextInt();
        type = input.next().charAt(0);
        fullMatrix(matrix,input);

        if (type==sum){
            System.out.printf("%.1f\n",calculateSum(matrix,LineNumber));
        }
        else if(type==average){
            System.out.printf("%.1f\n",calculateAvg(matrix,calculateSum(matrix,LineNumber)));
        }

    }

    public static void fullMatrix(double [][] matrix, Scanner input){

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]= input.nextInt();
            }
        }
    }

    public static double calculateSum(double [][] matrix, int LineNumber){
        double sumOfLine=0.0;
        for (int i = 0; i < matrix.length ; i++) {
            sumOfLine+=matrix[LineNumber][i];
        }
        return sumOfLine;
    }
    public static double calculateAvg(double [][] matrix,double sumOfLine){
        double averageOfLine = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            averageOfLine = sumOfLine / matrix.length;
        }
        return averageOfLine;
    }
}
