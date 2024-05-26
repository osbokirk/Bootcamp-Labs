package org.example;

import java.util.Scanner;

public class UI {
    public static Order order;
    public static Scanner scanner  = new Scanner(System.in);

    public static void homeScreen(){
        order = new Order();
        System.out.println("""
            WELCOME BACK      
            1)New Order:
            0)EXIT:
            """);
        String input = scanner.next();
        switch (input){
            case "1":
                newOrder();
            case "0":
                System.exit(0);
            default:
                System.out.println("Sorry I Lets try that again");
                homeScreen();
        }
    }

    public static void newOrder(){
        System.out.println("""
                What Do You Want
                1)A Sandwhich
                2)A Drink
                3)Some Chips
                4)Checkout
                0)Cancel Order
                """);
        String input = scanner.next();
        switch (input) {
            case "1":order.items.add(SandwhichBuilder.StartSando());
            case "2"://drink
            case "3"://chip
            case "4"://checkout
            case "0": homeScreen();
            default:
                System.out.println("Lets Try Again");
                newOrder();
        }
    }

    public static void checkOut(){
        System.out.println(order.toString());
        System.out.println("""
                1)Confirm
                0)Cancel
                """);
        String input = scanner.next();
        switch (input){
            case "1":
                FileManger.printRecipe(order);
                homeScreen();
            case"2":
                homeScreen();
            default:
                System.out.println("Lets Try Again");
                checkOut();
        }
    }

}
