package com.workintech.model;

public class Magazine extends Item {
    private Publisher publisher;
    private boolean borrowed;

    public String getMagazineName() {
        return magazineName;
    }

    private String magazineName;

    public Magazine(int id, String title, Publisher publisher) {
        super(id, title);
        this.publisher = publisher;
        this.borrowed = false;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow(User user) {
        if (!borrowed && user.canBorrow()) {
            borrowed = true;
            user.borrowMagazine(this);
            System.out.println(getTitle() + " dergisi ödünç alındı. Kullanıcı: " + user.getName());
        } else {
            System.out.println("Dergi ödünç alınamadı.");
        }
    }

    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println(getTitle() + " dergisi geri iade edildi.");
        } else {
            System.out.println("Dergi geri iade edilemedi.");
        }
    }

    @Override
    public String toString() {
        return "Id: " +getId() + " | Dergi: " + getTitle() + " | Yayınevi: " + publisher.getName() + " | Ödünç Alınabilir Durum: " + (!borrowed ? "Müsait" : "Ödünç Alınmış");
    }

}
