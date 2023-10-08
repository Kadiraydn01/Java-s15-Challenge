package com.workintech.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList librarians;
    private List<Member> members;
    private ArrayList books;
    private ArrayList authors;
    private ArrayList magazines;

    public Library(int id) {
        this.librarians = new ArrayList<>();
        this.members = new ArrayList<>();
        this.books =new ArrayList<>();
        this.authors =new ArrayList<>();
        this.magazines =new ArrayList<>();
    }
    public void addMember(Member member){
        members.add(member);
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
}
