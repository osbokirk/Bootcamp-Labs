package org.example;

import java.util.Scanner;

public class Screen {
    private static Scanner scanner = new Scanner(System.in);
    private static Book[] library;

    public Screen(){
        initLibrary();
    }

    public void initLibrary(){
        this.library = new Book[20];
        //library[0] = new Book(1,"HolyText");
        for(int x = 0; x < library.length;x++){
            if (x<10) {
                library[x] = new Book(x, "HolyText" + x, " 867-530-900"+x);
            }else{
                library[x] = new Book(x, "HolyText" + x, "867-530-90"+x);
            }
        }
    }

    public static void homeScreenWelcome() {
        System.out.printf("""
                \\________\\--------___       ___         ____----------/_________/
                    \\_______\\----\\\\\\\\\\\\   //_ _ \\\\    //////-------/________/
                        \\______\\----\\\\|| (( ~|~ )))  ||//------/________/
                            \\_____\\---\\\\ ((\\ = / ))) //----/_____/
                                 \\____\\--\\_)))  \\ _)))---/____/
                                       \\__/  (((     (((_/
                Andrew Fabbro          |  -)))  -  ))
                
                __________________________________________________________________________
                                   WELCOME TO HEAVENLY BOOKS
                \n""");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void homeScreen(){
        homeScreenWelcome();
        System.out.println("""
                                        Would you like to  
                                      1) See Available Books
                                     2) Show CheckedOut Books
                                             3)Leave         
                                                 
                """);
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
                break;
        }
    }
    public static void allBooks(){
        System.out.println("""
                               Here is out current collection
                               
         __________________________________________________________________________
             ID                   ISBN                             TITLE
         """);
        //System.out.println("_____________________________\n" +
               // );
        for (int x = 0;x < library.length;x++){
            if(library[x].isCheckout() == false) {
                System.out.printf("""
                        __________________________________________________________________________
                            %s                 %s                      %s
                        """,library[x].getId() ,library[x].getIsbn(), library[x].getTitle());
            }
        }
        System.out.println("""
                                         \n
                                         1)checkout
                                           2)exit
        """);
        int input = scanner.nextInt();
        switch (input){
            case 1:
                checkOut();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.printf("""
                                       "Sorry I did not understand that love"
                        """);
                allBooks();
        }
    }

    public static void checkOut(){
       boolean found = false;
        do{
            System.out.println("     What is the Name of the book would you like to checkout\n               ");
            scanner.nextLine();
            String book = scanner.nextLine();
            System.out.println("                Excellent, And what was you name again\n               ");
            String userName = scanner.next();

            for (int x = 0;x < library.length && !found  ;x++){
                if(library[x].getTitle().equals(book)){
                    library[x].checkOut(userName);
                    //library[x].setCheckout(true);
                    //library[x].setCheckedOutTo(userName);
                    //System.out.println(library[x].getCheckoutResponce()+"\n");
                    found = true;


                    homeScreen();
                }
            }
        }while (found = false);
    }

    public static void checkedOutBooks(){
        System.out.println("""
                    ID         ISBN             TITLE                         OWNER
               """);
        //System.out.println("\nID      ISBN       TITLE       OWNER");

        for (Book book:library){
            if (book.isCheckout() == true){
                //change ansi color to read
                System.out.printf("""
                        __________________________________________________________________________
                           %d     %s            %s                     %s
                        """,book.getId(),book.getIsbn(),
                        book.getTitle(),book.getCheckedOutTo());
            }
        }

        System.out.printf("""
                                    \n
                                    Would you like to 
                                    C) CheckIn a book 
                                 X) Return to Home Screen
        """);
        scanner.nextLine();
        String input = scanner.nextLine();
        switch (input.toUpperCase()){
            case "C":
                //check in method
                checkIn();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                homeScreen();
            case "X":
                System.out.println("Understood\n"+"\n");
                homeScreen();
        }
    }

    public static void checkIn(){
        System.out.printf("""
                      Please enter the ID of the book you'd like to return
        """ );
        //scanner.nextLine();
        int returnedBook = scanner.nextInt();
        for (int x = 0; x < library.length ;x++){
            if(library[x].getId()==returnedBook  && library[x].isCheckout() == true){
                library[x].checkIn();
                //library[x].setCheckout(false);
                //library[x].setCheckedOutTo("null");
                System.out.println("""
                                        Thank you for returning this beloved classic \n\n
                        """);
            }
        }
    }



}
