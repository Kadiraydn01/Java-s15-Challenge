package com.workintech.model;

public class Librarian extends Person{
    private String name;
    private int id;
    public Librarian(String name, int id) {
        super(name, id);
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
