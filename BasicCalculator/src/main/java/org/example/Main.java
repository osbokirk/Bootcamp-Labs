package org.example;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a scanner class that takes and 2 values
        Scanner userInput = new Scanner(System.in);
        Float firstNumber = null;
        Float secondNumber = null;
        Float sum;

        //prompt user for 1st input and save the value
        System.out.println("Enter the first Number :");
        while(firstNumber == null) {
            try {
                firstNumber = userInput.nextFloat();

            }catch (InputMismatchException e){
                System.out.println("hello");
                break;
                //continue;
            }


                //throw new InputMismatchException("sorry You didn't enter a valid float");

                //firstNumber = userInput.nextFloat();

        }

        //prompt user for 2nd input and save the value
        System.out.println("Enter the second Number :");
        while(secondNumber == null) {
            try {
                secondNumber = userInput.nextFloat();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("sorry You didn't enter a valid float");
            }
        }

        //prompt the user for there wanted action && return result
        System.out.println("Possible Calculations:\n    (A)dd\n    (S)ubtract\n    (M)ultiply\n    (D)ivide");
        userInput.nextLine();
        String artimitic = userInput.nextLine();

        /*
        if (artimitic.length() > 0 || ( artimitic.equalsIgnoreCase("A")  ||artimitic.equalsIgnoreCase("D") ||
                artimitic.equalsIgnoreCase("S") || artimitic.equalsIgnoreCase("M"))){
            System.out.println("fight");
        }
        */
        if (artimitic.equalsIgnoreCase("A")){
            sum = firstNumber + secondNumber;
            System.out.println(sum);
        }
        else if(artimitic.equalsIgnoreCase("S")){
            sum = firstNumber - secondNumber;
            System.out.println(sum);
        }
        else if(artimitic.equalsIgnoreCase("M")){
            sum = firstNumber * secondNumber;
            System.out.println(sum);
        }
        else if(artimitic.equalsIgnoreCase("D")){
            sum = firstNumber/secondNumber;
            System.out.println(sum);
        }
        else{
            System.out.println("Sorry invalid option");
        }
    }
}