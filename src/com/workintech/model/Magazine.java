package com.workintech.model;

public class Magazine extends Item {
    private Publisher publisher;
    private boolean borrowed;
    private String name;

    public Magazine(int id, String title, Publisher publisher, boolean borrowed, String name) {
        super(id, title);
        this.publisher = publisher;
        this.borrowed = borrowed;
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Object getMagazinename() {
        return name;
    }
    public void borrow(User user){
        if(!borrowed && user.canBorrow()){
            borrowed = true;
            user.borrowMagazine(this);
            System.out.println(getTitle() + " dergisi ödünç alındı. Kullanıcı: " + user.getName());
        }else {
            System.out.println("Dergi ödünç alınamadı.");
        }
    }

    public void returnItem(User user) {
        if (borrowed && user.magazineHasBorrowed(this)) {
            borrowed = false;
            user.returnItem(this);
            System.out.println(getTitle() + " dergisi geri iade edildi.");
        } else {
            System.out.println("Dergi geri iade edilemedi.");
        }
    }
}
