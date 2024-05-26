package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sandwhich implements Sellable {
    public static List<String>  vegOptions= Stream.of("Onion","Tomatoes").collect(Collectors.toList());
    public static List<String>  vegOptions2= List.of("Onion","Tomatoes");
    public static List<String> meatOptions= Stream.of("Ham","Turkey").collect(Collectors.toList());
    public static List<String>  cheeseOptions = Stream.of("Swiss","American").collect(Collectors.toList());
    public static List<String>  breadOptions = Stream.of("White","Wheat").collect(Collectors.toList());
    public static List<String>  sauceOptions = Stream.of("Vinegar","Olive Oil").collect(Collectors.toList());

    public HashMap<String,Double> meats = new HashMap<>();
    public HashMap <String,Double> veg = new HashMap<>();
    public HashMap <String,Double> cheeses = new HashMap<>();
    public HashMap <String,Double> sauseces = new HashMap<>();
    boolean isToasted;

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
        String string = "Meats \n";
        for(String meat : meats.keySet()){string = string + (meat +"...x"+ meats.get(meat))+"\n";}
        for(String vegs : veg.keySet()){string = string + (vegs +"...x"+ veg.get(vegs))+"\n";}
        for(String che : cheeses.keySet()){string = string + (che +"...x"+ cheeses.get(che))+"\n";}
        for(String sau : sauseces.keySet()){string = string + (sau +"...x"+ sauseces.get(sau))+"\n";}

        /*
        this.meats.keySet().stream().map(x -> x.toString()).forEach(x -> string.concat(x + "x" + meats.get(x)));
        string.concat("Cheeses");
        this.cheeses.keySet().stream().forEach(x -> string.concat(x + "x" + cheeses.get(x) ));
        this.veg.keySet().stream().forEach(x -> string.concat(x + "x" + veg.get(x) ));
        this.sauseces.keySet().stream().forEach(x -> string.concat(x + "x" + sauseces.get(x) ));
        string.concat(String.valueOf(isToasted));


         */
        return string;
    }
}
