package com.JH.Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static File readFromWebToFile(String urlPath){
        File file = new File("C:\\Users\\basel_c8nyn\\OneDrive - Al Azhar University\\Desktop\\week5\\src\\com\\JH\\Task3\\Source.txt");
        try{
            URL url = new URL(urlPath);
            Scanner scanner = new Scanner(url.openStream());
            FileWriter writer = new FileWriter(file);
            while (scanner.hasNext()){
                int data = scanner.nextInt();
                writer.write(data);

            }
            writer.close();
            scanner.close();
        }catch (IOException e){
            System.out.println("Error reading from the web" + e.getMessage());
        }
        return file;
    }

    public static int getSum(File file){
        int sum = 0;
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                sum += scanner.nextInt();
            }
            scanner.close();
        }catch (IOException e){
            System.out.println("Error reading data from the file: " + e.getMessage());
        }
        return sum;
    }

    public static double getAvg(File file){
        int sum = getSum(file);
        double numScores = 0;
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                numScores++;
                scanner.next();
            }
            scanner.close();
        }catch (IOException e){
            System.out.println("Error reading data from the file: " + e.getMessage());
        }
        return sum/numScores;
    }


    public static void main(String [] args){

//        String urlPath = "http://liveexample.pearsoncmg.com/data/Sco
//        res.txt";
//        File file = readFromWebToFile(urlPath);
        File file = new File("C:\\Users\\basel_c8nyn\\OneDrive - Al Azhar University\\Desktop\\week5\\src\\com\\JH\\Task3\\Source.txt");

        int sum = getSum(file);
        double average = getAvg(file);
        System.out.println("the sum of the scores is " + sum);
        System.out.println("the average of the scores is " + average);

    }
}
