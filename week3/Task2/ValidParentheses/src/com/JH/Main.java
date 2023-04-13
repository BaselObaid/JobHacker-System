package com.JH;


import java.util.Stack;

/*
 *@baselObaid
 * in this problem i use stack data structure to push the symbols
 * if a symbol has it opposite we will pop it from the stack
 * in the end if the stack empty then the string s is valid
 */
public class Main {

    public static boolean isValid(String s) {
        if(s.length()<1 && s.length()>10000){
            return false;
        }
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c== '['){
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
	String s = "({[[]]})";
        System.out.println(isValid(s));
    }
}
