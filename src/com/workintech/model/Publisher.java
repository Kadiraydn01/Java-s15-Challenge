package com.workintech.model;

public class Publisher extends Item{
    private String name;
    private int id;

    public Publisher(int id, String title, String name, int id1) {
        super(id, title);
        this.name = name;
        this.id = id1;
    }

    public String getName() {
        return name;
    }
}
