package org.example;

import java.util.ArrayList;
import java.util.List;

public class Chip implements Sellable {
    public static List<String> flavorsList = List.of("sourCream && onion","cheese puff","original", "bbq");
    private String flavor;
    public final double price  = 1.50;

    public Chip() {
    }

    public Chip(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

    public static List<String> getFlavorsList() {
        return flavorsList;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        String output = "Chip "+getFlavor()+ "...."+getPrice();
        return output;
    }
}
