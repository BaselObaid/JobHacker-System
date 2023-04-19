package com.JH;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    static Library library = new Library("GoodReader", 123);

    public static void main(String[] args) {
        Menu();
    }


    // this method to search if a book is exists in the library by id
    // if it exists return this book
    // if not return null
    public static Book searchInLibrary(int id) {
        for (int i = 0; i < library.getLibraryBooks().size(); i++) {
            if (library.getLibraryBooks().get(i).getId() == id) {
                return library.getLibraryBooks().get(i);
            }
        }
        return null;
    }


    // this method to search in array list of users on a user by user id
    // if this user is exists return it
    // if not return null
    public static User searchInUsers(ArrayList<User> users, int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }

        }
        return null;
    }


    // static method to add some books to the library object (for test)
    public static void addBookData() {
        library.addNewBook(new Book("Java1", "a1", 1, 1.1f, true));
        library.addNewBook(new Book("Java2", "a2", 2, 1.1f, true));
        library.addNewBook(new Book("Java3", "a3", 3, 1.1f, true));
        library.addNewBook(new Book("Java4", "a4", 4, 1.1f, true));
        library.addNewBook(new Book("Java5", "a5", 5, 1.1f, true));
        library.addNewBook(new Book("Java6", "a6", 6, 1.1f, false));
    }

    // static method to add some reader data (for test)
    public static void addUserData(ArrayList<User> users) {
        User user1, user2, user3, user4, user5;
        user1 = new User("ahmed", 1);
        user2 = new User("mohamed", 2);
        user3 = new User("basel", 3);
        user4 = new User("karim", 4);
        user5 = new User("mansour", 5);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

    }

    // this method to show the second menu of main operations
    // ( add a new book - remove a book - checkout book - return a book - display all of available books
    // - display all of borrowed books - display a book - finish the program)
    public static void Menu(){
        ArrayList<User> users = new ArrayList<>();
        addUserData(users);
        addBookData();
        boolean flag = true;
        Scanner inputData = new Scanner(System.in);
        Scanner inputOperation = new Scanner(System.in);
        int bookId, readerId, operationNumber;
        String authorName, bookTitle;
        float version;
        boolean availableBook;

        while (flag) {
            System.out.println("1- ADD NEW BOOK.\n2- REMOVE BOOK.\n" +
                    "3- CHECKOUT BOOK AND GIVE IT TO USER IF AVAILABLE.\n4- RETURN BOOK.\n" +
                    "5- DISPLAY AVAILABLE BOOKS.\n6- DISPLAY A SPECIFIC BOOK.\n" +
                    "7- DISPLAY BORROWED BOOKS\n8- ENTER ANY KEY TO EXIST (not 1 to 7) ");
            System.out.println("ENTER THE OPERATION NUMBER");
            try {
                operationNumber = inputOperation.nextInt();
            }catch (InputMismatchException e){
                operationNumber=8;
            }
            switch (operationNumber) {
                case 1: {
                    System.out.println("******{ADD NEW BOOK}******");
                    System.out.println("enter the title: ");
                    bookTitle = inputData.next();
                    System.out.println("enter the author name:");
                    authorName = inputData.next();
                    while (true) {
                        System.out.println("enter the book ID:");
                        try {
                            bookId = inputData.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer ID.");
                            inputData.nextLine(); // clear the input buffer
                        }
                    }
                    System.out.println("enter the version:");
                    while (true) {
                        try {
                            version = inputData.nextFloat();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid float version.");
                            inputData.nextLine();
                        }
                    }

                    System.out.println("enter availability(true or false):");
                    while (true) {
                        try {
                            availableBook = inputData.nextBoolean();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid boolean (true or false).");
                            inputData.nextLine();
                        }
                    }
                    library.addNewBook(new Book(bookTitle, authorName, bookId, version, availableBook));
                    break;
                }
                case 2:
                    System.out.println("******{REMOVE BOOK}******");
                    System.out.println("enter the book ID:");
                    try {
                        bookId = inputData.nextInt();
                        library.removeBook(searchInLibrary(bookId));
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine();
                        continue;
                    }

                case 3:
                    System.out.println("******{CHECKOUT BOOK}******");
                    System.out.println("Enter Reader Id");
                    try {
                        readerId = inputData.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine(); // clear the input buffer
                        break;
                    }
                    System.out.println("Enter Book Id");
                    try {
                        bookId = inputData.nextInt();
                        if (searchInUsers(users, readerId) != null && searchInLibrary(bookId) != null) {
                            library.checkoutBook(searchInUsers(users, readerId), searchInLibrary(bookId));
                        } else {
                            System.out.println("reader id or book id is not exit");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine();
                        break;
                    }

                case 4:
                    System.out.println("******{RETURN BOOK}******");
                    System.out.println("Enter Reader Id");
                    try {
                        readerId = inputData.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine(); // clear the input buffer
                        break;
                    }
                    System.out.println("Enter Book Id");
                    try {
                        bookId = inputData.nextInt();
                        if (searchInUsers(users, readerId) != null && searchInLibrary(bookId) != null) {
                            library.returnBook(searchInUsers(users, readerId), searchInLibrary(bookId));
                        } else {
                            System.out.println("reader id or book id is not exit");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine();
                        break;
                    }

                case 5:
                    System.out.println("******{DISPLAY AVAILABLE BOOKS}******");
                    library.displayAvailableBooks();
                    break;
                case 6:
                    System.out.println("******{DISPLAY A SPECIFIC BOOK}******");
                    System.out.println("Enter Book Id");
                    try {
                        bookId = inputData.nextInt();
                        library.displaySpecificBook(bookId);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        inputData.nextLine();
                        break;
                    }
                case 7:
                    System.out.println("******{DISPLAY BORROWED BOOKS}******");
                    library.displayBorrowedBooks();
                    break;
                default:
                    flag = false;
                    System.out.println("finish the program");
                    break;
            }
        }
    }

}













