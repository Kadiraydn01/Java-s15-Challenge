package com.workintech.model;

public abstract class Item {
    private int id;
    private String title;
    private int publisherId;
    private int authorId;
    private String type;


    public Item(int id, String title) {
        this.id = id;
        this.title = title;
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public int getAuthorId() {
        return authorId;
    }
}
