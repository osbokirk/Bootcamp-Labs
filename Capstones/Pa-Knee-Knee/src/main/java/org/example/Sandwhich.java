package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwhich implements Sellable {
    public static List<String>  vegOptions= Arrays.asList("Lettuce","Onion","Tomatoes","Peppers","Jalepenos","Cucumber","Pickles","Guacamole","Mushrooms");
    //public static List<String>  vegOptions2= List.of("Lettuce","Onion","Tomatoes","Peppers","Jalepenos","Cucumber","Pickles","Guacamole","Mushrooms");
    public static List<String> meatOptions= Arrays.asList("Ham","Turkey","Steak","Salami","Roast");
    public static List<String>  cheeseOptions = Arrays.asList("American","Provolone","Cheddar","Swiss");//Arra
    public static List<String>  breadOptions = Arrays.asList("White","Wheat","Rye", "Wrap");
    public static List<String> sauceOptions = Arrays.asList("Vinegar","Olive Oil","Mayo","Mustard","Ketchup","Ranch","Thousand Islands","Vinaigrette");
    public static List<String> sideOptions = Arrays.asList("Au jus","Sauce");


    public HashMap<String,Double> meats = new HashMap<>();
    public HashMap <String,Double> veg = new HashMap<>();
    public HashMap <String,Double> cheeses = new HashMap<>();
    public HashMap <String,Double> sauseces = new HashMap<>();
    public HashMap <String,Double> sides= new HashMap<>();
    boolean isToasted = false;


    public Sandwhich buildTest(){
        Sandwhich sammmy = new Sandwhich();
        return sammmy;
    }

    public static List<String> getVegOptions() {
        return vegOptions;
    }

    public static List<String> getMeatOptions() {
        return meatOptions;
    }

    public static List<String> getCheeseOptions() {
        return cheeseOptions;
    }

    public static List<String> getBreadOptions() {
        return breadOptions;
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
    public void addSide(String side){
        if(sides.containsKey(side)){
            sides.replace(side,sides.get(side)+1);
        }else{
            sides.put(side,1.0);
        }
    }
    public static Sandwhich buildBLT(Sandwhich s){
        s.addMeat("Bacon");
        s.addVeg("Lettuce");
        s.addVeg("Tomato");
        s.addCheese("Cheddar");
        s.addSauses("Ranch");
        s.isToasted = true;
        return s;
    }
    public String toString(){
        String string ="";
        if( this.meats.keySet().size()>0){
            string = string + "------MEATS-----\n";
            for(Map.Entry<String, Double> meat : meats.entrySet()){
                string = string + (meat.getKey() +"...*"+ meat.getValue())+"\n";
            }
        }

        if( this.veg.keySet().size()>0){
            string = string + "------VEGGIES-----\n";
            for(Map.Entry<String,Double> vegs : veg.entrySet()){
                string = string + (vegs.getKey() +"...*"+ vegs.getValue())+"\n";
            }
        }
        if( this.cheeses.keySet().size()>0){
            string =string + "------CHEESES-----\n";
            for(String che : cheeses.keySet()){
                string = string + (che +"...*"+ cheeses.get(che))+"\n";
            }
        }
        if( this.sauseces.keySet().size()>0){
            string = string + "------SAUCES-----\n";
            for(String sau : sauseces.keySet()){
                string = string + (sau +"...*"+ sauseces.get(sau))+"\n";
            }
        }
        if( this.sides.keySet().size()>0){
            string = string + "______SIDES______\n";
            for (String side: sides.keySet()){
                string = string + (side + "...*"+ sides.get(side)) + "\n";
            }
        }

        return string;
    }
}
