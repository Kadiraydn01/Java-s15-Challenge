package com.workintech.model;

public abstract class Item {
    private int id;
    private String name;
    private int publisherId;
    private int authorId;
    private String type;


    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.publisherId = publisherId;
        this.authorId = authorId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }
    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public int getAuthorId() {
        return authorId;
    }
}
