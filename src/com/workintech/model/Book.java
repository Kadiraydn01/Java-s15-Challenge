package com.workintech.model;

public class Book extends Item {
    private final int id;
    private String title;
    private Author author;
    private Category category;
    private boolean borrowed;
    private double rating;
    private final String publisher;

    public Book(int id, String title, Author author, Category category, boolean borrowed, double rating, String publisher) {
        super(id, title);
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

    public double getRating() {
        return rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }



    public void updateBookInfo(String title , Author author , Category category){
        this.title= title;
        this.author = author;
        this.category = category;
    }

    @Override
    public String getTitle() {
        return title;
    }



    @Override
    public String toString() {
        return  "Id: " + getId() + " | " +
                " Kitap: " + getName() + " | " +
                " Yazar: " + getAuthor().getName() + " | " +
                " Kategori: " +getCategory().getName() + " | " +
                " Rating: " + getRating() + " | " +
                " Yayınevi: "+ getPublisher();

    }


}

