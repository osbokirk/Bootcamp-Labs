package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class fourInchSub extends Sandwhich implements Sellable{
    //private HashMap <String,Double> meats = new HashMap<>();
    //private HashMap <String,Double> veg= new HashMap<>();
    //private HashMap <String,Double> cheese = new HashMap<>();
    //private String bread;
    //private HashMap <String,Double> sauseces = new HashMap<>();
    private static final double BasePrice = 5.50;
    private static final double meatPrice = 1.00;
    static final double extraMeat = .50;
    private static final double cheesePrice = .75;
    static final double extraCheese = .30;
    private String bread;
    public String getBread() {
        return bread;
    }

    @Override
    public String toString() {
        String s = "4 Inch Sub \n"+super.toString() + getPrice();
        return s;
    }
    //public static ArrayList vegOptions= new ArrayList<>();
    //public static ArrayList meatOptions= new ArrayList<>();
   // public static ArrayList cheeseOptions = new ArrayList<>();
    //public static ArrayList breadOptions = new ArrayList<>();


    public fourInchSub(String bread) {
        this.bread = bread;
    }

    @Override
    public double getPrice() {
        double total  = BasePrice;
        int meatCount = (int) this.meats.values().stream().mapToDouble(value -> value).sum();
        if(meatCount >= 1){total += meatPrice + (meatCount - 1) * extraMeat;}
        int cheeseCount = (int) this.cheeses.values().stream().mapToDouble(value -> value).sum();
        if(cheeseCount >= 1){total += cheesePrice + (cheeseCount -1) * extraCheese;}
        return total;
    }






}
