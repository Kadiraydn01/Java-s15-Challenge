package com.workintech.model;

public class Magazine extends Item {
    private Publisher publisher;
    private boolean borrowed;
    private String name;

    public Magazine(int id, String title, Publisher publisher, boolean borrowed, String name) {
        super(id, title);
        this.publisher = publisher;
        this.borrowed = borrowed;
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public String getName() {
        return name;
    }
}
