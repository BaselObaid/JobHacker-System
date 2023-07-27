package com.jobhacker;

import java.util.*;

public class SetOfNumbers {

    /*
     * take the number of test cases
     * take the number of the query in the test case
     * take the operation's type [a, b, c, d, e]
     * a x : insert an x to the set
     * b : print the set in increasing order
     * c x : delete an x from the set
     * d x : print (1) if x is existing in the set if not print (-1)
     * e : print the size of the set
     */

    public static void main(String[] args) {

        // i will use treeSet because it doesn't take duplicate members, and it will store in ascending
        Set<Integer> integerSet  = new TreeSet<>();
        int setMember;

        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        scanner.nextLine();

        while(noOfTestCases != 0){
            int noOfQueries = scanner.nextInt();
            scanner.nextLine();

            while (noOfQueries !=0){
                char typeOfOperation = scanner.next().charAt(0);
                scanner.nextLine();
                
                switch (typeOfOperation){
                    case 'a' :
                        setMember = scanner.nextInt();
                        integerSet.add(setMember);
                    break;
                    case 'b' :
                        Iterator iterator = integerSet.iterator();
                        while (iterator.hasNext()){
                            System.out.print(iterator.next() + " ");
                        }
                    break;
                    case 'c' : {
                        setMember = scanner.nextInt();
                        if (integerSet.contains(setMember))
                            integerSet.remove(setMember);
                        scanner.nextLine();
                    }
                    break;
                    case 'd' : {
                        setMember = scanner.nextInt();
                        if (integerSet.contains(setMember))
                            System.out.println(1);
                        else
                            System.out.println(-1);
                        scanner.nextLine();
                    }
                    break;
                    case 'e' :
                        System.out.println(integerSet.size());
                    break;
                }
                noOfQueries--;
            }
            noOfTestCases--;
        }

    }
}
