package com.JH;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int testCases = scanner.nextInt();

            for (int t = 0; t < testCases; t++) {
                int queries = scanner.nextInt();
                LinkedHashSet<Integer> set = new LinkedHashSet<>();

                for (int q = 0; q < queries; q++) {
                    char operation = scanner.next().charAt(0);

                    switch (operation) {
                        case 'a':
                            int num = scanner.nextInt();
                            set.add(num);
                            break;
                        case 'b':
                            printSet(set);
                            break;
                        case 'c':
                            int deleteNum = scanner.nextInt();
                            set.remove(deleteNum);
                            break;
                        case 'd':
                            int searchNum = scanner.nextInt();
                            System.out.println(set.contains(searchNum) ? "1" : "-1");
                            break;
                        case 'e':
                            System.out.println(set.size());
                            break;
                        case 'f':
                            printSetInsertionOrder(set);
                            break;
                    }
                }
            }
        }

        private static void printSet(LinkedHashSet<Integer> set) {
            for (int num : set) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        private static void printSetInsertionOrder(LinkedHashSet<Integer> set) {
            System.out.println(set.toString().replaceAll("[\\[\\],]", ""));
        }


}
