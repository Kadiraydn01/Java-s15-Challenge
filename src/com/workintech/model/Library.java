package com.workintech.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private ArrayList librarians;
    private List<User> users;
    private ArrayList books;
    private ArrayList authors;
    private ArrayList magazines;

    public Library(int id) {
        this.librarians = new ArrayList<>();
        this.users = new ArrayList<>();
        this.books =new ArrayList<>();
        this.authors =new ArrayList<>();
        this.magazines =new ArrayList<>();
    }
    public void addMember(User user){
        users.add(user);
    }
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }
    public Author getAuthorById(int authorId){
        return (Author) authors.get(authorId);
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }
    public List<Book> getBooksByCategory(String categoryName) {
        List<Book> booksInCategory = new ArrayList<>();
        for(Object item : books) {
            if (item instanceof Book) {
                Book b = (Book) item;
                if ((b.getCategory().getName().equalsIgnoreCase(categoryName))){
                    booksInCategory.add(b);
                }
            }
        }
        return booksInCategory;
    }
}
