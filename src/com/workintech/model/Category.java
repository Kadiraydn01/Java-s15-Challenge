package com.workintech.model;

public class Category {
    private String name;
    private int id;

    public Category(String name) {
        this.id = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
