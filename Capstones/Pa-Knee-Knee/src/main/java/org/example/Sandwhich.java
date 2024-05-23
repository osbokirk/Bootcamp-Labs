package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public Class Sandwhich {
    public static ArrayList vegOptions= new ArrayList<>();
    public static ArrayList meatOptions= new ArrayList<>();
    public static ArrayList cheeseOptions = new ArrayList<>();
    public static ArrayList breadOptions = new ArrayList<>();

    public HashMap <String,Double> meats = new HashMap<>();
    public HashMap <String,Double> veg = new HashMap<>();
    public HashMap <String,Double> cheeses = new HashMap<>();
    public HashMap <String,Double> sauseces = new HashMap<>();

    public void getVegOptions(){
        System.out.println(vegOptions);
    }





public HashMap<String, Double> getMeats() {
    return meats;
}

public void setMeats(HashMap<String, Double> meats) {
    this.meats = meats;
}

public HashMap<String, Double> getVeg() {
    return veg;
}

public void setVeg(HashMap<String, Double> veg) {
    this.veg = veg;
}

public HashMap<String, Double> getCheese() {
    return cheese;
}

public void setCheese(HashMap<String, Double> cheese) {
    this.cheese = cheese;
}

public HashMap<String, Double> getSauseces() {
    return sauseces;
}

public void setSauseces(HashMap<String, Double> sauseces) {
    this.sauseces = sauseces;
}
public void addMeat(String meat){
    if (meats.containsKey(meat)){
        meats.replace(meat,meats.get(meat)+1);
    }else {
        meats.put(meat,1.0);
    }
}

public void addVeg(String veggies){
    if (veg.containsKey(veggies)){
        veg.replace(veggies,veg.get(veggies)+1);
    }else {
        veg.put(veggies,1.0);
    }
}

public void addSauses(String sauce){
    if (sauseces.containsKey(sauce)){
        sauseces.replace(sauce,sauseces.get(sauce)+1);
    }else {
        sauseces.put(sauce,1.0);
    }
}

public void addCheese(String cheese){
    if (cheeses.containsKey(cheese)){
        cheeses.replace(cheese,cheeses.get(cheese)+1);
    }else {
        cheeses.put(cheese,1.0);
    }
}



}

