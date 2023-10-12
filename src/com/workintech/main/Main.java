package com.workintech.main;

import com.workintech.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

        Category category1 = new Category("Roman");
        Category category2 = new Category("Şiir");
        Category category3 = new Category("Tarihi");

        System.out.println(category3.getName());
        Publisher publisher1 = new Publisher(1, "Yayınevi", "Can Yayınları");
        Publisher publisher2 = new Publisher(2, "Yayınevi", "Sancak Grup");

        User user2 = new User("Emin" , "Emin0203",250);
        User user1= new User("Ahmet" ,"Bjk1903" ,345);

        addUser(library, user1);
        addUser(library, user2);

        Book book1 = new Book(1, "Romeo ve Juliet", author1, category1, false, 5, "Can Kitapevi");
        Book book2 = new Book(2, "Bir Âşığın Yakınması", author1, category2, false, 4,"Yaşam Yayınları");
        Book book3 = new Book(3, "Hacı Murat", author3, category3, false, 4.5,"Neşeli Yayınlar");
        Book book4 = new Book(4, "Anna Karenina", author3, category3, false, 4,"Sevgi Yayınları");
        Book book5 = new Book(5, "İnsancıklar", author2, category1, false, 3.5,"Can Yayınları");
        Book book6 = new Book(6, "Suç ve Ceza", author2, category1, false, 5,"Nokta Yayınları");

        addBook(library, book1);
        addBook(library, book2);
        addBook(library, book3);
        addBook(library, book4);
        addBook(library, book5);
        addBook(library, book6);

        Magazine magazine = new Magazine(1, "FourFourTwo", publisher2);
        Magazine magazine1 = new Magazine(2, "Atlas", publisher1);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Adınız: ");
        String userName = scanner.nextLine();
        System.out.println("Şifrenizi Giriniz: ");
        String password = scanner.next();
        System.out.println("Kullanıcı Adı: " + userName);
        System.out.println("Şifre: " + password);

        scanner.nextLine();

        User currentUser = library.getUserByUsernameAndPassword(userName,password);

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

private static void listBooks(Library library){
        System.out.println("Kütüphanede bulunan kitaplar: ");
        for (Object book : library.getBooks()){
            System.out.println(book.toString());
        }
    }

    public static void returnBook(User user ,Library library,Scanner scanner){
        System.out.println("İade etmek istediğiniz kitaplar:");
        ArrayList borrowedItem = new ArrayList(user.getBorrowedItems());
        borrowedItem.addAll(user.getBorrowedMagazines());

        for (int i = 0; i < borrowedItem.size(); i++){
            Object item = borrowedItem.get(i);
            if (item instanceof Book){
                Book book = (Book) item;
                System.out.println((i + 1) + ". " + book.getName());
            }
        }
        System.out.println("İade etmek istediğiniz kitap ID'sini girin: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();

        if(bookNumber >=1 && bookNumber <= borrowedItem.size()){
            Book book = (Book) borrowedItem.get(bookNumber -1 );
            if (book instanceof Book && user.bookHasBorrowed((Book) book)) {
                System.out.print("Kitaba puan vermek istiyor musunuz ? (Evet/Hayır) : ");
                String ratingChoice = scanner.nextLine();

                if (ratingChoice.equalsIgnoreCase("Evet")){
                    System.out.print("1 ile 5 arasında puan giriniz): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();

                    if (rating >= 1 && rating <= 5) {
                        book.setRating(rating);
                        System.out.println("Puanınız kaydedildi.");
                    } else {
                        System.out.println("Geçersiz puan değeri.");
                    }
                }
                user.returnItem(book);
                library.addBook((Book) book);
                System.out.println(((Book) book).getName() + " kitabı iade edildi.");
            }else {
                System.out.println("Geçersiz seçenek veya kitap kullanıcıya ait değil.");
            }
        }else {
            System.out.println("Geçersiz kitap ID.");
        }
    }

public static void borrowBook(User user ,Library library, Scanner scanner){
    System.out.println("Almak istediğiniz kitap ID'sini giriniz: ");
    int bookId = scanner.nextInt();
    scanner.nextLine();
    Book book = library.getBookById(bookId);

    if (book != null){
        if(user.canBorrow()){

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
    private static void updateBook(User user, Library library, Scanner scanner) {
        System.out.println("Güncellemek istediğiniz kitabın ID'sini girin: ");
        int bookID = scanner.nextInt() - 1;
        scanner.nextLine();

        List<Book> books = library.getBooks();

        if (bookID >= 0 && bookID < books.size()) {
            Book book = books.get(bookID);

            if (!user.bookHasBorrowed(book)) {
                System.out.print("Yeni başlık: ");
                String newTitle = scanner.nextLine();

                System.out.print("Yeni yazar adı: ");
                String authorName = scanner.nextLine();
                Author newAuthor = library.getAuthorByAuthorName(authorName);

                if (newAuthor == null) {

                    Random random = new Random();
                    int randomNumber = random.nextInt(101000);
                    newAuthor = new Author(authorName, randomNumber);
                }

                System.out.print("Yeni kategori adı: ");
                String newCategoryName = scanner.nextLine();
                Category newCategory = new Category(newCategoryName);

                book.updateBookInfo(newTitle, newAuthor, newCategory);
                System.out.println("Kitap bilgileri güncellendi.");
            } else {
                System.out.println("Bu kitap zaten ödünç alınmış durumda, güncelleyemezsiniz.");
            }
        } else {
            System.out.println("Geçersiz ID.");
        }
    }

    public static void listBooksByAuthor(Library library,Scanner scanner){
    System.out.println("Yazar adını giriniz: ");
    String authorName = scanner.nextLine();
    List<Book> booksByAuthor = library.getBooksByAuthor(authorName);

    System.out.println("Yazar " +authorName+ " ' için bulunan kitaplar:");
    for (Book book : booksByAuthor){
        System.out.println(book.getId() + ". " + book.getName() +" - " +book.getCategory().getName());
        System.out.println();
    }
}
    public static List<Book> getBooksByAuthorId(int authorId, List<Book> bookList) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(authorId)) {
                result.add(book);
            }
        }
        return result;
    }
public static void listBooksByCategory(Library library,Scanner scanner){
    System.out.print("Kategori adını giriniz: ");
    String categoryName = scanner.nextLine();
    List<Book> booksInCategory = library.getBooksByCategory(categoryName);
    List<Magazine> magazinesInCategory = library.getMagazinesByCategory(categoryName);

    System.out.println("Kategori '" + categoryName + "' için bulunan kitaplar:");
    for (Book book : booksInCategory){
        System.out.println(book.getName());
    }
    for (Magazine magazine: magazinesInCategory){
        System.out.println(magazine.getMagazinename() + ". " + magazine.getTitle()+ ". " + magazine.isBorrowed());

    }
}
private static void listMagazines(Library library){
    System.out.println("Kütüphaneki dergiler: ");
    for (Object magazine : library.getMagazines()){
        System.out.println();
    }
}
    public static void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println(book.getName() + " kütüphaneye eklendi.");
    }

    public static void addMagazine(Magazine magazine) {
        Library library = new Library(1);
        library.addMagazine(magazine);
        System.out.println(magazine.getTitle() + " kütüphaneye eklendi.");
    }

    public static void addUser(Library library, User user) {
        library.addMember(user);
        System.out.println(user.getName() + " kütüphane üyesi olarak kaydedildi.");
    }

}
