package org.example;

import java.util.Scanner;

public class SandwhichBuilder {
    public static Sandwhich StartSando(){
        Sandwhich sub = selectSize();
        if (comfirmPart("Your Sandwhich Toasted") == true){
            sub.isToasted = true;
        }
        if(comfirmPart("Meat") == true){
            SandwhichBuilder.addMeats(sub);
        }
        if(comfirmPart("Cheese") == true){
            SandwhichBuilder.addCheeses(sub);
        }
        if(comfirmPart("Sauces") == true){
            SandwhichBuilder.addSauces(sub);
        }
        if(comfirmPart("Veggies") == true){
            SandwhichBuilder.addVeggies(sub);
        }
        if(comfirmPart("Sides") == true){
            SandwhichBuilder.addSides(sub);
        }
        return sub;
    }



    public static Sandwhich selectSize(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ---SandWhich Sizes---
                0) 4 INCH
                1) 8 INCH
                2) 12 INCH
                """);
        System.out.print("Select Size: ");
        String input = scanner.next();
        switch (input){
            case "0":
                fourInchSub smallSub = new fourInchSub(chooseBread());
                return smallSub;

            case "1":
                eightInchSub medSub = new eightInchSub(chooseBread());
                return medSub;

            case "2":
                twelveInchSub longSub = new twelveInchSub(chooseBread());
                return longSub;

            default:
                System.out.println("Invalid Size Try Again");
                return selectSize();
        }

    }
    public static boolean comfirmPart(String prompt){
        System.out.print("Would You Like " + prompt +"(y/n): ");
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.next();
        if (input.toLowerCase().equals("y") ||input.toLowerCase().equals("yes") ){
           return true;
        }else {
            return false;
        }
    }



    public static String chooseBread(){
        String bread = "";
        boolean breadSet = false;
        do {
            for(int x = 0; x<Sandwhich.breadOptions.size();x++){
                System.out.println(x+ ")" +Sandwhich.breadOptions.get(x));
            }

            System.out.print("Please enter the index for Bread you'd like: ");

            Scanner scanner = new Scanner(System.in);
            String breadChoice = scanner.next();

                try{
                    Integer index = Integer.parseInt(breadChoice);
                    if (index <= Sandwhich.breadOptions.size()){
                        bread = Sandwhich.breadOptions.get(index);
                        breadSet = true;
                    }
                }catch (Exception e){
                    System.out.println();
                }
            if (breadSet==false){
                System.out.println("Sorry We Didn't Get That \nWhat Bread Would You Like We Have:");
            }
        }while(breadSet == false);
        return bread;
    }
    public static void addMeats(Sandwhich sandwhich){
        for(int x = 0; x<Sandwhich.meatOptions.size();x++){
            System.out.println(x+")"+ Sandwhich.meatOptions.get(x));
        }

        System.out.println("please inter the index number of meat you'd  like for multiple meats seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String meatsChoices = scanner.nextLine();
        String[] meatIndex = meatsChoices.split(",");
        for(String meatChoice : meatIndex){
            Integer index= null;
            try{
                 index = Integer.parseInt(meatChoice);
            }catch (Exception e){
            }
            if(!index.equals(null)&& index <= Sandwhich.meatOptions.size()){
                sandwhich.addMeat(Sandwhich.meatOptions.get(index));
            }
        }
    }

    public static void addVeggies(Sandwhich sandwhich){
        for(int x = 0; x<Sandwhich.vegOptions.size();x++){
            System.out.println( x + ")" + Sandwhich.vegOptions.get(x));
        }
        System.out.println("please inter the index number of veg you'd  like for multiple meats seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String vegChoices = scanner.nextLine();
        String[] vegIndex = vegChoices.split(",");
        for(String choice : vegIndex){
            Integer index=null;
            try{
                index = Integer.parseInt(choice);
            }catch (Exception e){
            }
            if( !index.equals(null) && index <= Sandwhich.vegOptions.size()){
                sandwhich.addVeg(Sandwhich.vegOptions.get(index));
            }
        }
    }
    public static void addCheeses(Sandwhich sandwhich){
        for(int x = 0; x<Sandwhich.cheeseOptions.size();x++){
            System.out.println(x+")"+Sandwhich.cheeseOptions.get(x));
        }
        System.out.println("please inter the index number of cheese you'd  like for multiple meats seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String chesseChoices = scanner.nextLine();
        String[] cheeseIndex = chesseChoices.split(",");
        for(String choice : cheeseIndex){
            Integer index=null;
            try{
                index = Integer.parseInt(choice);
            }catch (Exception e){
            }
            if( !index.equals(null) && index <= Sandwhich.cheeseOptions.size()){
                sandwhich.addCheese(Sandwhich.cheeseOptions.get(index));
            }
        }
    }
    public static void addSauces(Sandwhich sandwhich){
        for(int x = 0; x<Sandwhich.sauceOptions.size();x++){
            System.out.println(x + ")" + Sandwhich.sauceOptions.get(x));
        }
        System.out.println("please inter the index number of Sauce you'd  like for multiple Sauces seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String sauceChoices = scanner.nextLine();
        String[] sauceIndex = sauceChoices.split(",");
        for(String choice : sauceIndex){
            Integer index = null;
            try{
                index = Integer.parseInt(choice);
            }catch (Exception e){
            }
            if( !index.equals(null) && index <= Sandwhich.sauceOptions.size()){
                sandwhich.addSauses(Sandwhich.sauceOptions.get(index));
            }
        }
    }
    public static void addSides(Sandwhich sandwhich){
        for(int x = 0; x<Sandwhich.sideOptions.size(); x++){
            System.out.println(x + ")" + Sandwhich.sideOptions.get(x) );
        }

        System.out.println("please inter the index number of Sauce you'd  like for multiple Sauces seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String sideChoices = scanner.nextLine();
        String[] sideIndex = sideChoices.split(",");
        for(String choice : sideIndex){
            Integer index = null;
            try{
                index = Integer.parseInt(choice);
            }catch (Exception e){
            }
            if( !index.equals(null) && index <= Sandwhich.sideOptions.size()){
                sandwhich.addSide(Sandwhich.sideOptions.get(index));
            }
        }
    }










}
