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
            0)EXIT:""");
        System.out.print("Select Option: ");
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
                1)A Sandwich
                2)A Drink
                3)Some Chips
                4)Checkout
                0)Cancel Order""");
        System.out.print("Select Option: ");
        String input = scanner.next();
        switch (input) {
            case "1":order.items.add(SandwhichBuilder.StartSando());
            newOrder();
            case "3":order.items.add(ChipBuilder.makeChip());
            newOrder();
            case "2":order.items.add(DrinkBuilder.buildDrink(new Drink()));
            newOrder();
            case "4":checkOut();
            case "0": homeScreen();
            default:
                System.out.println("Lets Try Again");
                newOrder();
        }
    }

    public static void checkOut(){
        System.out.print(order.toString());
        System.out.println("""
                1)Confirm
                0)Cancel""");
        System.out.print("Select A Option :");
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
