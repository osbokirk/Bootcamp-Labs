package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       fourInchSub min = new fourInchSub("italian");
       //Sandwhich.getVegOptions();
        fourInchSub d = new fourInchSub(SandwhichBuilder.chooseBread());
        SandwhichBuilder.addMeats(d);
        SandwhichBuilder.addCheeses(d);
        SandwhichBuilder.addVeggies(d);
        SandwhichBuilder.addSauces(d);


    }
}