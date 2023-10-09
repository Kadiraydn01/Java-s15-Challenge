package com.workintech.model;

public class Book extends Category {
    private int id;
    private Author author;
    private Category category;
    private boolean borrowed;
    private int rating;
    private String publisher;
    public Book(int id, String name, String publisher) {
        super(name, id);
        this.publisher = publisher;
    }

    public Book(int id, String title, Author author, Category category, boolean borrowed, int rating, String publisher) {
        super(title, id);
        this.author = author;
        this.category = category;
        this.borrowed = borrowed;
        this.rating = rating;
        this.id = id;
        this.publisher = publisher;

    }


    @Override
    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

