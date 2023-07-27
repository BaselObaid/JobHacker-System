package com.jobhacker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dictionary {

   /*
    * create a map that uses the alphabets as keys and a string as values (this collection should only contain words that starts with the corresponding key)
    * Develop an application that stores words into that collection
    * elements in the words map for each alphabet should be stored
    * provide methods to print all the letters and corresponding words
    * provide a method to print the words of the given letter
    */


    private HashMap<Character, List<String>> dictionary= new HashMap<>();
    // initialize the dictionary with index from a to z
    public Dictionary(){
        char letter = 'a';
        for (int i = 0; i < 26; i++) {
            dictionary.put(letter, new ArrayList<>());
            letter++;
        }
    }

    // now we will make addWord Method to add the word to our dictionary
    public void addWord(String word){

        if(word != null || !word.isEmpty()){
            char firstLetter = word.charAt(0);
            List<String> words = dictionary.get(firstLetter);// get the list of this key
            // Check if the word is already present in the list
            if (!words.contains(word)) {
                words.add(word);
                dictionary.put(firstLetter, words); // update in our dictionary
            }else {
                System.out.println("this word \"" + word + "\" is already exist");
            }
        }
        else{
            System.err.println("you add an empty word");
        }
    }

    // now we will make method to print all indexes by their keys
    public void printAll(){
        char letter = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.println("***** " + letter + " *****");
            for(String word : dictionary.get(letter)){
                System.out.println("*" + word);
            }
            letter++;
        }
    }

    // we will now make a method to print the words of the given letter
    public void printByLettersIndex(char letter){
        List<String> wordsStartByTheLetter = dictionary.get(letter);
        System.out.println("*** "+letter+" ***");
        for (String word : wordsStartByTheLetter){
            System.out.println(word);
        }
    }
    public static void main(String [] args){

        Dictionary dictionary = new Dictionary();
        //testcases
        dictionary.addWord("ahmed");
        dictionary.addWord("basel");
        dictionary.addWord("amal");
        dictionary.addWord("car");
        dictionary.addWord("yaya");

        dictionary.addWord("car");

        dictionary.printAll();
        
        dictionary.printByLettersIndex('y');

    }

}
