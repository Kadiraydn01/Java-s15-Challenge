package com.workintech.model;

import java.util.*;

@SuppressWarnings("ALL")
public class User implements Barrowable {
    private String name;
    private int borrowedBooksCount;
    public ArrayList borrowedItems = new ArrayList();
    private Map<Book, Integer> bookRatings;
    private double fineAmount;
    private double balance;
    private String password;
    public User(int id, String name,String password, double initialBalance) {

        this.borrowedBooksCount = 0;
        this.borrowedItems = new ArrayList();
        this.bookRatings = new HashMap<>();
        this.fineAmount = 0;
        this.password = password;
        this.name =  name;
        this.balance = initialBalance;
    }
    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedBooksCount < 5;
    }
public ArrayList<Integer> getBorrowedBooks(){
        Iterator<Integer> iterator = borrowedItems.iterator();
        while (iterator.hasNext()){
            Integer item = iterator.next();
            if(item instanceof Integer){
                iterator.remove();

            }
        }
    ArrayList arrayList = new ArrayList(borrowedItems);
    return arrayList;
}

    public List<Magazine> getBorrowedMagazines() {
        return new ArrayList<>(borrowedItems);
    }





    public void returnItem(Magazine book) {
        if (borrowedItems.contains(book)) {
            borrowedItems.remove(book);
            borrowedBooksCount--;
        }
    }


    public int getRating(Book book) {
        return bookRatings.getOrDefault(book, 0);
    }
    public void rateBook(Book book , int rating){
        if(rating >= 0 && rating <= 5){
            bookRatings.put(book , rating);
        }
    }
    public void payFine(double amount) {
        fineAmount -= amount;
        System.out.println("Ödenen Ceza Miktarı: " + amount);
    }

    public double getTotalFineAmount() {
        return fineAmount;
    }
    public boolean bookHasBorrowed(Book book) {
        return borrowedItems.contains(book);
    }
    public boolean magazineHasBorrowed(Magazine magazine) {
        return borrowedItems.contains(magazine);
    }

    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }

    public double getFineAmount() {
        return fineAmount;
    }
@Override
    public void borrowBook(Book book) {
        if (!borrowedItems.contains(book) && canBorrow() && balance >= 5.0) {
            borrowedItems.add(book.getId());
            borrowedBooksCount++;
            balance-= 5;
        }
}
@Override
public void borrowMagazine(Magazine magazine) {
    if (!borrowedItems.contains(magazine) && canBorrow()) {
        borrowedItems.add(magazine.getId());
        borrowedBooksCount++;
    }
}


}
