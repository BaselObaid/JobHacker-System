package com.JH;
import java.util.Scanner;

/*
 *@BaselObaid
 * Reverse a string
 */

public class Main {

    public static String reverseString(String string){
        String temp="";
        for(int i = string.length()-1; i >= 0;i--){
            temp += string.charAt(i);
        }
        string =temp;
        return string;
    }
    public static void printStrings(String string){
        System.out.println("the reverse is : " + string);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.next();
        String reverse ="";
        reverse= reverseString(string);
        printStrings(reverse);

        //another solution using StringBuilder
        StringBuilder sb = new StringBuilder(string);
        reverse = sb.reverse().toString();
        printStrings(reverse);
    }
}
