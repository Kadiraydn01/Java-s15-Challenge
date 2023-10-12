package com.workintech.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private String name;
    private int id;
    private String title;
    private static List<Author> authors = new ArrayList<>();

    public Author(String name, int id) {
        super(name, id);
        this.name = name;
        this.id = id;
        authors.add(this);
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getName();
    }
}
