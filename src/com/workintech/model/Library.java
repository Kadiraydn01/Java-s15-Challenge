package com.workintech.model;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList getBooks() {
        return books;
    }

    public ArrayList getMagazines() {
        return magazines;
    }
    public List<Book> getBooksByCategory(String categoryName) {
        List<Book> booksInCategory = new ArrayList<>();
        for(Object item : books) {
            if (item instanceof Book b) {
                if ((b.getCategory().getName().equalsIgnoreCase(categoryName))){
                    booksInCategory.add(b);
                }
            }
        }
        return booksInCategory;
    }

    public Book getBookById(int bookId){
        for (Object item : books){
            if(item instanceof Book book){
                if(book.getId() ==bookId){
                    return book;
                }
            }
        }
        return null;
    }

    public List<Magazine> getMagazinesByCategory(String categoryName) {
        List<Magazine> magazinesInCategory = new ArrayList<>();
        for (Object magazine : magazines) {
            if (magazine instanceof Magazine) {
                if (((Magazine) magazine).getMagazinename() != null) {
                    magazinesInCategory.add((Magazine) magazine);
                }
            }
        }
        return magazinesInCategory;
    }
    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        for(Object item : books) {
            if (item instanceof Book b) {
                String author = b.getAuthor().getTitle();
                if ((author.equals(authorName))){
                    booksByAuthor.add(b);
                }
            }
        }
        return booksByAuthor;
    }
    public Author getAuthorByAuthorName(String authorName) {
        Author authorInfo = null;
        for (Object item : authors) {
            if (item instanceof Author) {
                authorInfo = (Author) item;
            }
        }
        return authorInfo;
    }
    public List<Magazine> getMagazinesByAuthor(String authorName) {
        List<Magazine> magazinesByAuthor = new ArrayList<>();
        for (Object magazine : magazines) {
            if (magazine instanceof Magazine) {
                if (((Magazine) magazine).getMagazinename() != null) {
                    magazinesByAuthor.add((Magazine) magazine);
                }
            }
        }
        return magazinesByAuthor;
    }


}
