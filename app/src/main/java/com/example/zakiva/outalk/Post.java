package com.example.zakiva.outalk;

/**
 * Created by zakiva on 5/12/16.
 */

public class Post {

    private String message;
    private String author;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    Post() {
    }

    Post(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}