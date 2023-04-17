package com.JH;

import java.util.Arrays;

/*
 *@BaselObaid
 * first we will sort the array then the smallest word will be in strs[0]
 * then we will loop on all characters in this smallest word and compare it with the tallest word
 * then return lcp
 */

public class LongestCommonPrefix {


    public static String longestCommonPrefix(String[] strs) {

        int size = strs.length;
        if (strs == null) {
            return "";
        }
        if (size == 1){
            return strs[0];
        }
        Arrays.sort(strs);

        int i = 0;
        while (i < strs[0].length() && strs[0].charAt(i) == strs[size-1].charAt(i) )
            i++;

        String lcp = strs[0].substring(0, i);
        return lcp;

    }
    public static void main(String[] args) {
        String [] strs = {"flower","flow","fly"};
        String lcp = longestCommonPrefix(strs);
        System.out.println(lcp);
    }
}
