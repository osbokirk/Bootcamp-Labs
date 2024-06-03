package org.example;

import java.util.Scanner;

public class ChipBuilder {

    public static Chip makeChip(){
        Chip chip = new Chip();
        System.out.println("---Chip Flavors--");
        //Chip.getFlavorsList().stream().forEach(x-> System.out.println(x));
        for(int x = 0;x<Chip.getFlavorsList().size();x++){
            System.out.println(x + ")" + Chip.getFlavorsList().get(x));
        }
        System.out.println("Please Enter The Flavor You'd Like");
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        do {
            String input = scanner.nextLine();
            if (Chip.getFlavorsList().size() >= Integer.parseInt(input)) {
                chip.setFlavor(Chip.getFlavorsList().get(Integer.parseInt(input)));
                stop = true;
            }else{
                System.out.println("We Dont Have That Flavor, We Have");
                for(int x = 0;x<Chip.getFlavorsList().size();x++){
                    System.out.println(x + ")" + Chip.getFlavorsList().get(x));
                }
                System.out.print("Select A VALID Flavor :");
            }
        }while(stop == false);
        return chip;
    }
}
