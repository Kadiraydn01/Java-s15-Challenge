package com.workintech.model;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private ArrayList<Librarian> librarians;
    private List<User> users;
    private ArrayList<Book> books;
    private ArrayList<Author> authors;
    private ArrayList<Magazine> magazines;

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
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
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

    public User getUserByUsernameAndPassword(String name, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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

    @Override
    public String toString() {
        return "Library{" +
                "librarians=" + librarians +
                ", users=" + users +
                ", books=" + books +
                ", authors=" + authors +
                ", magazines=" + magazines +
                '}';
    }
}
