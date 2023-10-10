package com.workintech.main;

import com.workintech.model.*;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("Kadir" , 1);
        Library library = new Library(1);
        library.addLibrarian(librarian);
        Author author1 = new Author("William Shakespeare" ,1);
        Author author2 = new Author("Fyodor Dostoevsky" ,2);
        Author author3 = new Author("Leo Tolstoy" ,3);

        Category category1 = new Category("Roman",1);
        Category category2 = new Category("Şiir",2);
        Category category3 = new Category("Tarihi",3);

        Publisher publisher1 = new Publisher(1, "Yayınevi", "Can Yayınları");
        Publisher publisher2 = new Publisher(2, "Yayınevi", "Sancak Grup");

        User user2 = new User(1,"Emin" , "Emin0203",250);
        User user1= new User(2,"Ahmet" ,"Bjk1903" ,345);

        Book book1 = new Book(1, "Romeo ve Juliet", author1, category1, false, 5, "Can Yayınları");
        Book book2 = new Book(2, "Bir Âşığın Yakınması", author1, category2, false, 4,"Can Yayınları");
        Book book3 = new Book(3, "Hacı Murat", author3, category3, false, 4.5,"Can Yayınları");
        Book book4 = new Book(4, "Anna Karenina", author3, category3, false, 4,"Can Yayınları");
        Book book5 = new Book(5, "İnsancıklar", author2, category1, false, 3.5,"Can Yayınları");
        Book book6 = new Book(6, "Suç ve Ceza", author2, category1, false, 5,"Can Yayınları");


        Magazine magazine = new Magazine(1, "FourFourTwo", publisher2);
        Magazine magazine1 = new Magazine(2, "Atlas", publisher1);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Adınız: ");
        String userName = scanner.nextLine();
        System.out.println("Şifrenizi Giriniz: ");
        String password = scanner.next();
        scanner.nextLine();

        User currentUser = null;

        for (User user : library.getUsers()){
            if (user.getName().equals(userName) && user.getPassword().equals(password)){
                currentUser = user;
                break;
            }
        }
        if (currentUser == null) {
            System.out.println("Kullanıcı bulunamadı!");
            return;

        }
            System.out.println("Hoşgeldiniz " + currentUser.getName()+"! " +"Bakiyeniz: " + currentUser.getBalance() + "Lütfen yapmak istediğiniz işlemi seçiniz");
                while (true){
                    System.out.println("1. Kitapları Listele");
                    System.out.println("2. Kitap İade Et");
                    System.out.println("3. Kitap Al");
                    System.out.println("4. Kitap Bilgilerini Güncelle");
                    System.out.println("5. Yazarlara Göre Kitapları Listele");
                    System.out.println("6. Kategorilere Göre Kitapları Listele");
                    System.out.println("7. Çıkış");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){
                        case 1:
                            listBooks(library);
                            break;
                        case 2:
                            returnBook(currentUser,library,scanner);
                            break;
                        case 3:
                            borrowBook(currentUser,library,scanner);
                            break;
                        case 4:
                            updateBook(currentUser,library,scanner);
                            break;
                        case 5:
                            listBooksByAuthor(library, scanner);
                            break;
                        case 6:
                            listBooksByCategory(library, scanner);
                            break;
                        case 7:
                            System.out.println("Çıkış yapılıyor.");
                            return;
                        default:
                            System.out.println("Geçersiz seçenek.");
                    }
                }
    }
public static void borrowBook(User user ,Library library, Scanner scanner){
    System.out.println("Almak istediğiniz kitap ID'sini giriniz: ");
    int bookId = scanner.nextInt();
    scanner.nextLine();
    Book book = library.getBookById(bookId);

    if (book != null){
        if(user.canBorrow()){
            user.borrowBook(book);
            user.borrowedItems.add(book);
            library.removeBook(book);
            System.out.println(book.getName() + " ödünç alındı. Kalan Bakiyeniz: " + user.getBalance());
        }else {
            System.out.println("Ödünç alınamadı. Bakiyeniz yetersiz!");
        }
    }else {
        System.out.println("Geçersiz Id! Lütfen geçerli bir Id giriniz.");
    }
}



}