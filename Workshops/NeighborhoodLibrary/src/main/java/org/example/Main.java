package org.example;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Book[] library;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Book[] library= new Book[20];
        //library[0] = new Book(1,"test");
        for(int x = 1; x < library.length;x++){
            library[x] = new Book(x,"test"+x);
        }
        Main.homeScreenWelcome();
        Main.homeScreen();


    }
    public static void homeScreenWelcome() {
    System.out.println("___________________________");
    }
    public static void homeScreen(){
        System.out.println("would you like to \n 1) See Avalible Books \n" +
                "2) Show Checkedout Books \n 3)Leave ");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                allBooks();
                break;

            case 2:
                checkedOutBooks();
                break;
            case 3:
                System.exit(0);
            default:
                homeScreen();
        }

    }
    public static void allBooks(){
        System.out.println("Here is out current collection");
        System.out.println("_____________________________\n" +
                "ID            ISBN               TITLE");
        for (Book book: library){
            System.out.println(book.getId()+"       "+book.getIsbn()+"      "+book.getTitle());
        }
        System.out.println("1)checkout\n2exit");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                checkOut();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("sorry I did not understand that love");
                allBooks();
        }
    }
    public static void checkOut(){
        //should be broken into its own method
        System.out.println("what book would you like to checkout");
        String book = scanner.nextLine();
        System.out.println("Excellent And what was you name again");

        String userName = scanner.nextLine();
        boolean found = false;
        for (int x =0;x< library.length && found == false ;x++){
            if(library[x].getTitle() == book){
                library[x].setCheckout(true);
                library[x].setCheckedOutTo(userName);
                System.out.println(library[x].getCheckoutResponce());

                found = true;
            }
        }

    }
    public static void checkedOutBooks(){
        System.out.println("_____________________");
        System.out.println("\nID      ISBN       TITLE       OWNER");

        for (Book book:library){
            if (book.isCheckout() == true){
                //change ansi color to read
                System.out.println(book.getId()+""+book.getIsbn()+""+
                        book.getTitle()+""+book.getCheckedOutTo());
            }
        }
        System.out.println("would you like to \n" +
                "C)CheckIn a book \n X) Return to Home Screen ");
        String input = scanner.nextLine();
        switch (input.toUpperCase()){
            case "C":
                //check in method
                checkIn();
            case "X":
                System.out.println("Understood");
                homeScreen();
        }
    }
    public static void checkIn(){
        System.out.println("please enter the name of the book you'd like to return" );
        String  returnedBook = scanner.nextLine();
        for (int x = 0;x< library.length ;x++){
            if(library[x].getTitle() == returnedBook && library[x].isCheckout() ==true){
                library[x].setCheckout(false);
                library[x].setCheckedOutTo("null");
            }
        }


    }



}

