package com.JH;

/*
 *@BaselObaid
 * sentence must have 26 letters at least so,
 * we will make an array of 26 index
 * we know that each character has a number,so
 * we loop on the sentence then take each character and menus it from 'a' and make that number the index of array
 * if each index full by true then sentence is pangram
 */

public class Main {

    static int ALPHABET_LETTERS = 26;
    public static boolean checkIfPangram(String sentence) {

        if(sentence.length() < 1 || sentence.length() > 1000){
            return false;
        }
        sentence = sentence.toLowerCase();

        boolean [] array = new boolean[ALPHABET_LETTERS];

        for(char ch : sentence.toCharArray()){
            array[ch - 'a']= true;
        }
        for(boolean b : array){
            if(!b){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
	String s = "abcxyzdefuvwghirstjklopqmn";
    boolean t = checkIfPangram(s);
        System.out.println(t);
    }
}
