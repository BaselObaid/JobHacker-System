package com.JH.Task2;

import java.io.FileInputStream;

public class Main {

    public static void main(String [] args){

        String fileNameDirectory = "C:\\Users\\basel_c8nyn\\OneDrive - Al Azhar University\\Desktop\\week5\\src\\com\\JH\\Task2\\Lincoln.txt";

        try{
            FileInputStream file = new FileInputStream(fileNameDirectory);
            int counter  = 0;
            int i=0;
            while ((i= file.read())!=-1){
                if((char)i == ' '|| (char)i == '\n'){
                    counter++;
                }
            }
            System.out.println();
            System.out.println("the number of words is: " + counter);

        }catch (Exception ex){
            System.out.println("not found this directory");
        }
    }

}
