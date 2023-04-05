package com.JH;
/*
 *@BaselObaid
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double [][] matrix = new double[4][4];
        String sum = "S", average = "M", type;

        Scanner input = new Scanner(System.in);
        type = input.next();
        fullMatrix(matrix);
        
        if (type.equals(sum)){
            System.out.printf("%.1f\n",calculateSum(matrix));
        }
        else if(type.equals(average)){
            System.out.printf("%.1f\n",calculateAvg(matrix));
        }

    }

    // to full a matrix by elements
    public static void fullMatrix(double [][] matrix){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]= input.nextInt();
            }
        }
    }


    public static double calculateSum(double [][] matrix){
        double sum = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static double calculateAvg(double [][]matrix){
        double avg = 0, sum = 0;
        int count = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        avg = sum / count;
        return avg;
    }
}
