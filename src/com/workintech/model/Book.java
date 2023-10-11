package com.workintech.model;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Book extends Item {
    private int id;
    private Author author;
    private Category category;
    private boolean borrowed;
    private double rating;
    private String publisher;
    private User owner;
    public Book(int id, String name, String publisher) {
        super(id, name);
        this.publisher = publisher;
    }

    public Book(int id, String title, Author author, Category category, boolean borrowed, double rating, String publisher) {
        super(id, title);
        this.author = author;
        this.category = category;
        this.borrowed = borrowed;
        this.rating = rating;
        this.id = id;
        this.publisher = publisher;

    }


    @Override
    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    private final ArrayList borrowedItems = new ArrayList();
    public ArrayList getBorrowedItems() {

        return new ArrayList<>(borrowedItems);
    }
    public void borrow(User user){
        if(!borrowed && user.canBorrow()){
            borrowed = true;
            user.borrowBook(this);
            System.out.println(getName() + " ödünç alındı. Kullanıcı : " + user.getName());
        }else {
            System.out.println("Kitap ödünç alınamadı.");
        }
    }

    public void returnItem(User user){
        if(borrowed && user.bookHasBorrowed(this)){
            borrowed = false;
            System.out.println("Kitap iade edildi.");
        }else {
            System.out.println("Kitap iade edilmedi." );
        }
    }

    public void updateBookInfo(String title , Author author , Category category){
        this.author = author;
        this.category = category;
    }
    private boolean borrowed(){
        return false;
    }
    private static void listBooks(Library library) {
        System.out.println("Kütüphanedeki kitaplar:");
        for (Object book : library.getBooks()) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + " | " +
                " Kitap: " + getName() + " | " +
                " Yazar: " + getAuthor().getName() + " | " +
                " Kategori: " +getCategory().getName() + " | " +
                " Rating: " + getRating() + " | " +
                " Yayınevi: "+ getPublisher();

    }
}

