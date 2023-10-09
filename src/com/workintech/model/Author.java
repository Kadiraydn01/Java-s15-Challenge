package com.workintech.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Item {
    private String name;
    private int id;
    private static List<Author> authors = new ArrayList<>();

    public Author(String name, int id) {
        super(id, name);
        this.name = name;
        this.id = id;
        authors.add(this);
    }
    public List<Item> getBorrowedItems() {
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }
    public static List<Author> getAll() {
        return authors;
    }

    @Override
    public String toString() {
        return getName();
    }
}
