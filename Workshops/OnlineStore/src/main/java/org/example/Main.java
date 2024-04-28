package org.example;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Product,Integer> cart;
    static List<Product> inventory;

    public static void main(String[] args) {
     inventory = Screen.importInventory();
     cart = new HashMap<>();
     MusicPlayer.MusicPlayer();
     Screen.welcome();
    }
}