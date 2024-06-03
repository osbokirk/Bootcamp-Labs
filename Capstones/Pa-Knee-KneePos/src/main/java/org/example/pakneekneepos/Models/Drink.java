package org.example.pakneekneepos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Drink implements Sellable{
    public static Map<String, Double> priceChart = Map.ofEntries(entry("Small",2.00),entry("Medium",2.50),entry("Large",3.00));
    public static List<String> flavorList = Arrays.asList("strawBerry", "chocolate", "water");
    public String Size;
    public String flavor;
    //public Double price;

    public Drink() {
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return Size;
    }

    public static List<String> getFlavorList() {
        return flavorList;
    }



    public void setSize(String size) {
        Size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public static void setFlavorList(List<String> flavorList) {
        Drink.flavorList = flavorList;
    }

    public double getPrice(){
        return priceChart.get(Size);
    }
    public String toString(){
        String output = "Drink "+this.getFlavor() +"....."+this.getPrice();
        return output;
    }
}
