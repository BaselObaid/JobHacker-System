package com.JH;

import java.util.Scanner;

/*
 *@BaselObaid
 * check if a string is palindrome
 */

public class Main {

    // check if the string length is odd or not
    public static boolean isOddLengthString(String string){
        if((string.length()%2)==0)
            return false;
        else
            return true;
    }

    // take the left of the string by divide the string
    public static String cutTheLeftOfString(String string){
        String left="";
        int mid = string.length()/2;
        for (int i = 0; i < mid; i++) {
            left += string.charAt(i);
        }
        return left;
    }

    //reverse the right side of the string , the mid char not important!
    public static String reverseRightOfString(String string){
        String right="";
        int mid = string.length()/2;
        if(isOddLengthString(string)) {
            for (int i = string.length() - 1; i > mid; i--) {
                right += string.charAt(i);
            }
        }
        else{
            for (int i = string.length() - 1; i >= mid; i--) {
                right += string.charAt(i);
            }
        }
        return right;
    }

    //return true if the string is a palindrome
    public static boolean isAPalindromeString(String string){
        if (cutTheLeftOfString(string).equals(reverseRightOfString(string)))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        String string = "";
        Scanner input = new Scanner(System.in);
        string = input.next();
        System.out.println(isAPalindromeString(string));
    }
}
