package com.workintech.model;

public abstract class Item {
    private int id;
    private String name;


    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
