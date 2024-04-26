package org.example;

import java.io.FileNotFoundException;
import java.util.Map;

public class Main {
    private Map<Product,Integer> cart;
    private Product[] inventory;

    public static void main(String[] args) {
      Screen.importInventory();
    }
}