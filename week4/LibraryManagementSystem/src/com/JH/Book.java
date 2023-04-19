package com.JH;

public class Book {
    private String title;
    private String authorName;
    private int Id;
    private float version;
    private boolean available;

    public Book(String title, String authorName, int Id, float version, boolean available){
       this.title = title;
       this.authorName = authorName;
       this.Id = Id;
       this.version = version;
       this.available = available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
    public boolean getAvailable(){
        return available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    // this method check if the book is already exist (available) you can't return it
    // if it is not available (borrowed book) you can return it and make it available again
    public boolean returnBook() {
        if (available) {
            return false; // book is already available, cannot return
        } else {
            available = true;
            return true; // book returned successfully
        }
    }


}
