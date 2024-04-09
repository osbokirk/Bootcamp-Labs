package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a scanner class that takes and 2 values
        Scanner userInput = new Scanner(System.in);
        float firstNumber;
        float secondNumber;
        float sum;

        //prompt user for 1st input and save the value
        System.out.println("Enter the first Number :");
        firstNumber = userInput.nextFloat();
        //prompt user for 2nd input and save the value
        System.out.println("Enter the second Number :");
        secondNumber = userInput.nextFloat();



        //prompt the user for there wanted action && return result
        System.out.println("Possible Calculations:\n    (A)dd\n (S)ubtract\n    (M)ultiply\n    (D)ivide");
        userInput.nextLine();
        String artimitic = userInput.nextLine();


        if (artimitic.equalsIgnoreCase("A")){
            sum = firstNumber + secondNumber;
            System.out.println(sum);
        }else if(artimitic.equalsIgnoreCase("S")){
            sum = firstNumber - secondNumber;
            System.out.println(sum);
        }else if(artimitic.equalsIgnoreCase("M")){
            sum = firstNumber * secondNumber;
            System.out.println(sum);
        }else if(artimitic.equalsIgnoreCase("D")){
            sum = firstNumber/secondNumber;
            System.out.println(sum);
        }else{
            System.out.println("Sorry invalid option");
        }
    }
}