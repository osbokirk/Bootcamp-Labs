package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static org.example.Main.cart;
import static org.example.Main.inventory;

public class Screen {
    //initilize inventoy
    private static Scanner scanner = new Scanner(System.in);
    public static List<Product> importInventory(){
        String inventoryPath ="src/main/resources/products.csv";
        List<Product> inventory = new ArrayList();

        try(FileReader fileReader = new FileReader(inventoryPath)){
            BufferedReader reader = new BufferedReader(fileReader);
            reader.readLine();
            String currentProduct;

            while ((currentProduct=reader.readLine()) != null){
                //String currentProduct = reader.readLine();
                String[] x = currentProduct.split("\\|");
                Product product = new Product(x[0],x[1],Double.parseDouble(x[2]),x[3]);
                inventory.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

    //home
    public static void homeScreen(){
        System.out.println("""
                Hi Welcome To STORE 
                Would You Like To 
                
                1)Display Products
                2)Display Cart
                3)Exit 
                """);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                displayItems();
                break;
            case "2":
                displayCart();
                break;
            case "3":
                System.exit(0);
        }
    }

    //displayItems
    public static void displayItems(){
        for (int x = 0; x < inventory.size();x++){
            System.out.println(x + ") " + inventory.get(x).getProductName());
        }
        System.out.println("""
                Would You Like To 
                1)Filter
                2)Search
                3)Add Item Cart
                4)Go Back
                """);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                //filter;
               filter();
                break;
            case "2":
                System.out.println("Please enter the term you'd like to check");
                String searchTerm = scanner.nextLine();
                search(searchTerm);
                displayItems();

                //search
                break;
            case "4":
                    homeScreen();
                    break;
            case "3":
                System.out.println("Please Enter the Name or the SKU of the item You'd Like to add");
                addToCart(scanner.nextLine());
                break;
            default:
                System.out.println("I Didn't Get That");
        }
    }
    public static void addToCart(String input){
        for (int x = 0; x<inventory.size();x++){
            if (input.equalsIgnoreCase((inventory.get(x).getProductName()))||
                    input.equalsIgnoreCase(inventory.get(x).getSKU())){
                if (cart.size() > 0 || cart.containsKey(inventory.get(x))){
                    cart.replace(inventory.get(x),cart.get(inventory.get(x))+1);
                    System.out.println(inventory.get(x).getProductName() +"Was Added To Cart");
                }else{
                    cart.put(inventory.get(x),1);
                    System.out.println(inventory.get(x).getProductName() +"Was Added To Cart\n");
                }
                break;
            }
        }
        homeScreen();
    }


    /* below are they filter search and add methods,
     which I am unsure how to emplement at this time


    public static void clearAgreageate(){}
    */
    public static void filter(){
        //System.out.println("Would You Like To");
        //for (Product item: inventory){
            System.out.println("Would you like to filter by \n" +
                    "1)Department \n" +
                    "2)Price\"\"\"");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("1")) {
                System.out.println("enter the department youd like to filter by");
                String input2 = scanner.nextLine();
                filterCategory(input2);
                displayItems();
            }else if(input.equalsIgnoreCase("2")) {
                try {
                    System.out.println("Enter The Min value");
                    String min = scanner.nextLine();
                    System.out.println("Enter Max Value");
                    String max = scanner.nextLine();
                    Double minimum = Double.parseDouble(min);
                    Double maximum = Double.parseDouble(max);
                    filterPrice(minimum,maximum);
                    displayItems();
                }catch (NumberFormatException e){

                }
            }
    }

    public static void filterPrice(Double min,Double max){
        for (Product product : inventory){
            if(product.getPrice() >= min && product.getPrice() <= max){
                System.out.println(product.getSKU()+" | " + product.getProductName());
            }
        }
    }
    public static void filterCategory(String category){
        for (Product product:inventory){
            if (product.getCategory().equalsIgnoreCase(category)){
                System.out.println(product.getSKU() +" | "+ product.getProductName());
            }
        }
    }

    public static void search( String term){
        for (Product item: inventory){
            if (item.getProductName().contains(term)){
                System.out.println(item.getSKU()+" | "+item.getProductName());
            }
        }
    }
    //displayCart
    public static void displayCart(){
        System.out.println("Currently You Have In Your Cart");
        for(Product item :cart.keySet()){
            System.out.println(item.getProductName());
        }
        System.out.println("""
                Would You Like To
                1)Checkout
                2)Remove Item From Cart
                3)Back To Main
                """);
        String input = scanner.nextLine();
        switch (input){
            case "1":
               checkout();
                break;
            case "2":
                removeItem();
                break;
            case "3":
                homeScreen();
        }
    }
    public static void checkout(){
        System.out.println("Thank you for your patronage");
    }
    public static void removeItem(){
        System.out.println("Which Item Would You Like To Remove");

        int x = 0;
        for(Product items :cart.keySet()){
            System.out.println(x + ") +" + items.getProductName()+"   "+cart.get(items));
        }
        String input2 = scanner.nextLine();
        try{
            Integer index = Integer.parseInt(input2);
            System.out.println("");
            System.out.println("Great How many would you like to remove");
            int i = 0;

            for (Product items: cart.keySet()){
                if (i == index){
                    System.out.println("how many Items woudl you like to remove");
                    String input3 =  scanner.nextLine();
                    try{
                        Integer quantiry = Integer.parseInt(input3);
                        if (quantiry.equals(cart.get(items)) ) {
                            cart.remove(items);
                            displayCart();
                        }else if(quantiry < cart.get(items)){
                            cart.replace(items,cart.get(items), cart.get(items)-quantiry);
                        }else{
                            System.out.println("Sorry That's Not A Valid Quanity");
                            displayCart();
                        }
                    }catch (NumberFormatException y){
                        System.out.println("THATS NOT A NUMBER GET OUT");
                    }

                }
                i++;
            }

        }catch (NumberFormatException e){
            for(Product items : cart.keySet()){
                if (input2.equalsIgnoreCase(items.getProductName())){
                    System.out.println("Great How many would you like to remove");
                    String input3 =  scanner.nextLine();
                    try{
                        Integer quantiry = Integer.parseInt(input3);
                        if (quantiry.equals(cart.get(items)) ) {
                            cart.remove(items);
                            displayCart();
                        }else if(quantiry < cart.get(items)){
                            cart.replace(items,cart.get(items), cart.get(items)-quantiry);
                        }else{
                            System.out.println("Sorry That's Not A Valid Quanity");
                            displayCart();
                        }
                    }catch (NumberFormatException y){
                        System.out.println("THATS NOT A NUMBER GET OUT");
                    }
                }
            }
        }
    }
}

