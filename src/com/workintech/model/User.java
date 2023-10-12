package com.workintech.model;

import java.util.*;

public class User {
    private String name;
    private int borrowedBooksCount;
    public List<Item> borrowedItems;
    private Map<Book, Integer> bookRatings;
    private double fineAmount;
    private double balance;
    private String password;

    public User(String name, String password, double initialBalance) {
        this.name = name;
        this.password = password;
        this.borrowedBooksCount = 0;
        this.borrowedItems = new ArrayList<>();
        this.bookRatings = new HashMap<>();
        this.fineAmount = 0;
        this.balance = initialBalance;
    }
    public User(){}
    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedBooksCount < 5;
    }

    public List<Item> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public List<Magazine> getBorrowedMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for (Item item : borrowedItems) {
            if (item instanceof Magazine) {
                magazines.add((Magazine) item);
            }
        }
        return magazines;
    }

    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            borrowedBooksCount--;
        }
    }

    public boolean bookHasBorrowed(Book book) {
        for (Item item : borrowedItems) {
            if (item instanceof Book) {
                Book borrowedBook = (Book) item;
                if (borrowedBook.equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean magazineHasBorrowed(Magazine magazine) {
        for (Item item : borrowedItems) {
            if (item instanceof Magazine) {
                Magazine borrowedMagazine = (Magazine) item;
                if (borrowedMagazine.equals(magazine)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void borrowBook(Book book) {
        if (!bookHasBorrowed(book) && canBorrow() && balance >= 20.0) {
            borrowedItems.add(book);
            borrowedBooksCount++;
            balance -= 20;
        }
    }

    public void borrowMagazine(Magazine magazine) {
        if (!magazineHasBorrowed(magazine) && canBorrow()) {
            borrowedItems.add(magazine);
            borrowedBooksCount++;
            balance -= 20;
        }
    }
}
