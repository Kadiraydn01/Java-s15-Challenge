package com.workintech.model;

public class Publisher extends Item{
    private String name;

    public Publisher(int id, String title, String name) {
        super(id, title);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
