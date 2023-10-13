package com.workintech.model;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private ArrayList<Librarian> librarians;
    private List<User> users;
    private ArrayList<Book> books;
    private ArrayList<Author> authors;
    private ArrayList<Magazine> magazines;

    public Library() {
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
    public void removeMagazine(Magazine magazine){
        magazines.remove(magazine);
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

    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        allItems.addAll(books);
        allItems.addAll(magazines);
        return allItems;
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
    //equalsIgnoreCase = Küçük harflere çevirip karışıklığı önler.

    public Magazine getMagazineById(int magazineId) {
        for (Magazine magazine : magazines) {
            if (magazine.getId() == magazineId) {
                return magazine;
            }
        }
        return null;
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
                if (((Magazine) magazine).getMagazineName() != null) {
                    magazinesInCategory.add((Magazine) magazine);
                }
            }
        }
        return magazinesInCategory;
    }
    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Object item : books) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor() != null && book.getAuthor().getTitle() != null) {
                    String bookAuthorName = book.getAuthor().getTitle();
                    if (bookAuthorName.equals(authorName)) {
                        booksByAuthor.add(book);
                    }
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
