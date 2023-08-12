package com.JH;

import java.util.Scanner;

/*
 *@BaselObaid
 */

public class BelowTheMainDiagonal {

    public static final char SUM_OPERATION = 'S';
    public static final char AVERAGE_OPERATION = 'M';
    public static final int MATRIX_SIZE = 12;



    public static void main(String[] args) {

        char calculationType;
        Scanner input = new Scanner(System.in);
        calculationType = input.next().charAt(0);
        double[][] matrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        fullMatrix(matrix, input);

        if (calculationType == SUM_OPERATION) {
            System.out.printf("%.1f\n", calculateSum(matrix));
        } else if (calculationType == AVERAGE_OPERATION) {
            System.out.printf("%.1f\n", calculateAvg(matrix));
        } else {
            System.out.println("Invalid operation specified");
        }
    }

    // to fill a matrix by elements
    public static void fullMatrix(double[][] matrix, Scanner input) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
    }

    public static double calculateSum(double[][] matrix) {
        double sum = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static double calculateAvg(double[][] matrix) {
        double sum = 0;
        int count = (MATRIX_SIZE * (MATRIX_SIZE - 1)) / 2;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        return sum / count;
    }

}