package org.example;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckout = false;
    private String checkedOutTo = "null";
    private String checkoutResponce= "Thank You Return It Shortly";
    private String checkinResponce = "Thank You For Returning this";
    private String text;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name){

    }
    public void checkIn(){

    }

    public String getCheckoutResponce() {
        return checkoutResponce;
    }

    public void setCheckoutResponce(String checkoutResponce) {
        this.checkoutResponce = checkoutResponce;
    }

    public String getCheckinResponce() {
        return checkinResponce;
    }

    public void setCheckinResponce(String checkinResponce) {
        this.checkinResponce = checkinResponce;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
