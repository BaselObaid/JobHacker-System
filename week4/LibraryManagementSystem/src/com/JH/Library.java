package com.JH;

import java.util.ArrayList;

public class Library {

        private  String libraryName;
        private int LibraryCode;
        private ArrayList<Book> libraryBooks;



        public Library(String libraryName, int libraryCode) {
                this.libraryName = libraryName;
                LibraryCode = libraryCode;
                this.libraryBooks = new ArrayList<>();
        }

        public ArrayList<Book> getLibraryBooks() {
                return libraryBooks;
        }

        public void setLibraryBooks(ArrayList<Book> libraryBooks) {
                this.libraryBooks = libraryBooks;
        }


        //this method to add new book to the library if not exist
        public void addNewBook(Book book){
                if(!libraryBooks.contains(book)) {
                        this.libraryBooks.add(book);
                        System.out.println("The Books Was Added Successfully");
                }
                else{
                        System.out.println("this book is already exist");
                }
        }

        // this method to remove an exists book from the library
        public void removeBook(Book book){
                if(libraryBooks.contains(book)) {
                        this.libraryBooks.remove(book);
                        System.out.println("remove success");
                }
                else {
                        System.out.println("not exists book to remove");
                }
        }

        // this method is to check if this book is available
        // then if it is available add it to the list of borrowed books of this user, and make it unavailable
        // if this book not available, this user can't borrow it
        public boolean checkoutBook(User user, Book book) {
                if (book.getAvailable()) {
                        book.setAvailable(false);
                        user.addBorrowedBook(book);
                        System.out.println("book checked out successfully");
                        return true; // book checked out successfully
                } else {
                        System.out.println("book not available for checkout");
                        return false; // book not available for checkout
                }
        }

        // if the user want to return a book he borrows it
        public boolean returnBook(User user, Book book) {
                if (user.hasBorrowedBook(book)) {
                        System.out.println(user.getUserName() + " return this book: " + book.getTitle());
                        return book.returnBook(); // delegate to Book returnBook method
                } else {
                        System.out.println(user.getUserName() + " did not borrow this book");
                        return false; // user did not borrow this book
                }
        }


        private void displayBook(Book book){
                System.out.println(book.getAuthorName() + " | " +
                        book.getTitle() + " | " +
                        book.getId() + " | " +
                        book.getVersion() + " | " +
                        book.getAvailable() +
                        "\n***************************");
        }

        //return list of available books
        private ArrayList<Book> getAvailableBooks(){
                ArrayList<Book> availableBooks = new ArrayList<>();
                for (Book book : libraryBooks) {
                        if (book.getAvailable()){
                                availableBooks.add(book);
                        }
                }
                return availableBooks;
        }


        public void displayAvailableBooks(){
                for(Book book : getAvailableBooks()) {
                        displayBook(book);
                }
        }

        //return list of borrowed books
        private ArrayList<Book> getBorrowedBooks(){
                ArrayList<Book> borrowedBooks = new ArrayList<>();
                for(Book book : libraryBooks){
                        if (!book.getAvailable()){
                                borrowedBooks.add(book);
                        }
                }
                return borrowedBooks;
        }

        public void displayBorrowedBooks(){
                for(Book book : getBorrowedBooks()){
                       displayBook(book);
                }
        }

        // by the book id you can display the details of it
        public void displaySpecificBook(int bookId){
                for (Book book : libraryBooks){
                        if (bookId==book.getId()){
                                displayBook(book);
                        }
                        else{
                                System.out.println("this book is not exist");
                        }
                }
        }


}
