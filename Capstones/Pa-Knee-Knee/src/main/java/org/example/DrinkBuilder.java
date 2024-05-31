package org.example;

import java.util.Scanner;

public class DrinkBuilder {
    public static Drink buildDrink(Drink drink){
        DrinkBuilder.setSize(drink);
        DrinkBuilder.setFlavor(drink);
        return drink;
    }

    public static Drink setSize(Drink drink){
        System.out.println("""
                --Drink Options--
                0)Small.....2.00
                1)Medium....2.50
                2)Large ....3.00""");
        System.out.print("Select A Option: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input){
            case "0":
                drink.setSize("Small");
                break;
            case "1":
                drink.setSize("Medium");
                break;
            case "2":
                drink.setSize("Large");
                break;
            default:
                System.out.println("TRY AGAIN");
                DrinkBuilder.setSize(drink);
        }
        return drink;
    }

    public static Drink setFlavor(Drink drink){
        //Drink.getFlavorList().stream().forEach(x-> System.out.println(x));
        for (int x =0;x<Drink.getFlavorList().size();x++){
            System.out.println(x+")"+Drink.getFlavorList().get(x));
        }

            System.out.println("Please Enter The Index For The Flavor You'd Like");
            Scanner scanner = new Scanner(System.in);

            boolean stop = false;
            do {
                String input = scanner.nextLine();
                if (Drink.getFlavorList().size() <= Integer.parseInt(input)) {
                    drink.setFlavor(Drink.getFlavorList().get(Integer.parseInt(input)));
                    stop = true;
                }else{
                    System.out.println("Invalid Drink, We Have");
                    for (int x =0;x<Drink.getFlavorList().size();x++){
                        System.out.println(x+")"+Drink.getFlavorList().get(x));
                    }
                    System.out.print("Select A Appropriate Option");
                }
            }while(stop == false);
            return drink;
    }
}
