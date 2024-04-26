package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Screen {
    //initilize inventoy
    public static List<Product> importInventory(){
        String inventoryPath ="src/main/resources/products.csv";
        List<Product> inventory = new ArrayList();
        try(FileReader fileReader = new FileReader(inventoryPath)){
            BufferedReader reader = new BufferedReader(fileReader);
            reader.readLine();
            while (!reader.readLine().isEmpty()){
                String currentProduct = reader.readLine();
                String[] x = currentProduct.split("\\|");
                Product product = new Product(x[0],x[1],Double.parseDouble(x[2]),x[3]);
                inventory.add(product);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(inventory);
        return inventory;
    }

    //home
    public static void homeScreen(){

    }

    //displayItems
    public static void displayItems(){

    }
    public static void addToCart(){

    }
    /* below are they filter search and add methods,
     which I am unsure how to emplement at this time

    public static void filter(){}
    public static void search(){}
    public static void clearAgreageate(){}
    */

    //displayCart
    public static void displayCart(){

    }
    public static void checkout(){

    }
    public static void removeItem(){

    }
}
