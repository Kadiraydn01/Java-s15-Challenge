package com.workintech.model;

import java.util.*;

public class User extends Person implements Borrowable {

    private int borrowedBooksCount;
    public List<Item> borrowedItems;
    private List<Magazine> borrowedMagazines;
    private double balance;
    private String password;


    public User(String name,int id,String password, double balance) {
        super(name, id);
        this.balance = balance;
        this.password = password;
        this.borrowedItems = new ArrayList<>();
        this.borrowedMagazines = new ArrayList<>();
    }



    public boolean canBorrow() {
        return borrowedBooksCount < 5;
    }

    public List<Item> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public List<Magazine> getBorrowedMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for (Item item : borrowedMagazines) {
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

    public void decreaseBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Yetersiz bakiye.");
        }
    }

    public int getBorrowedBooksCount() {
        int bookCount = 0;
        for (Item item : borrowedItems) {
            if (item instanceof Book) {
                bookCount++;
            }
        }
        return bookCount;
    }
    public int getBorrowedMagazinesCount() {
        int bookCount = 0;
        for (Item item : borrowedItems) {
            if (item instanceof Magazine) {
                bookCount++;
            }
        }
        return bookCount;
    }
    public void increaseBalance(double amount) {
        balance += amount;
    }
    public void borrowMagazine(Magazine magazine) {
        if (!magazineHasBorrowed(magazine) && canBorrow()) {
            borrowedItems.add(magazine);
            borrowedBooksCount++;

        }
    }

    @Override
    public String toString() {
        return "User{" +
                "borrowedBooksCount=" + borrowedBooksCount +
                ", borrowedItems=" + borrowedItems +
                ", borrowedMagazines=" + borrowedMagazines +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}
