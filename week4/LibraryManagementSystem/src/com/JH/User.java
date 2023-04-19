package com.JH;

import java.util.ArrayList;

public class User {

    private String userName;
    private int userId;
    private ArrayList<Book> borrowedBooks;


    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    //this method return list of the books that user borrowed it
    // if it is empty return null
    public ArrayList<Book> getBorrowedBooks() {
        if (!borrowedBooks.isEmpty())
            return borrowedBooks;
        else {
            System.out.println("has no borrowed books");
            return null;
        }
    }

    //this method take the book which user want to borrow it and add it to the list of borrowed books
    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
        System.out.println("add Borrowed Book Successfully");
    }

    //this method take the book which user want to return it and remove it from the list of borrowed books
    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
        System.out.println("removed Borrowed Book Successfully");
    }

    // this method check if this book borrowed by this user
    public boolean hasBorrowedBook(Book book){
        return borrowedBooks.contains(book);
    }



}
