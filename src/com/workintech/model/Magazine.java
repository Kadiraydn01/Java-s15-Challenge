package com.workintech.model;

public class Magazine extends Item {
    private Publisher publisher;
    private boolean borrowed;
    private String magazineName;

    public Magazine(int id, String title, Publisher publisher) {
        super(id, title);
        this.publisher = publisher;
        this.borrowed = false;
    }

    public String getMagazineName() {
        return magazineName;
    }
    public boolean isBorrowed() {
        return borrowed;
    }


    @Override
    public String toString() {
        return "Id: " +getId() + " | Dergi: " + getTitle() + " | Yayınevi: " + publisher.getName() + " | Ödünç Alınabilir Durum: " + (!borrowed ? "Müsait" : "Ödünç Alınmış");
    }

}
