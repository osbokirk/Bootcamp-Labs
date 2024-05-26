package org.example;

import java.util.Scanner;

public class SandwhichBuilder {
    public static Sandwhich StartSando(){
        Scanner scanner = new Scanner(System.in);
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
                System.exit(0);
        }





        if(comfirmPart(scanner.next())== true){
        }

        return null;
    }
    public static boolean comfirmPart(String input){
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
            System.out.println(Sandwhich.breadOptions);
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
        System.out.println(Sandwhich.meatOptions );
        System.out.println("please inter the index number of meat you'd  like for multiple meats seperate by a comma");
        Scanner scanner = new Scanner(System.in);
        String meatsChoices = scanner.nextLine();
        String[] meatIndex = meatsChoices.split(",");
        for(String meatChoice : meatIndex){
            Integer index= null;
            try{
                 index = (int)Integer.parseInt(meatChoice);
            }catch (Exception e){
            }
            if(!index.equals(null)&& index <= Sandwhich.meatOptions.size()){
                sandwhich.addMeat(Sandwhich.meatOptions.get(index));
            }
        }
    }

    public static void addVeggies(Sandwhich sandwhich){
        System.out.println(Sandwhich.meatOptions );
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
                sandwhich.addMeat(Sandwhich.vegOptions.get(index+1));
            }
        }
    }
    public static void addCheeses(Sandwhich sandwhich){
        System.out.println(Sandwhich.meatOptions );
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
                sandwhich.addMeat(Sandwhich.cheeseOptions.get(index+1));
            }
        }
    }
    public static void addSauces(Sandwhich sandwhich){
        System.out.println(Sandwhich.sauceOptions );
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
                sandwhich.addSauses(Sandwhich.sauceOptions.get(index+1));
            }
        }
    }










}
