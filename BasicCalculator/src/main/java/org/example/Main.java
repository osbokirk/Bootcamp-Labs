package org.example;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a scanner class that takes and 2 values
        Scanner userInput = new Scanner(System.in);
        Float firstNumber = (float) 0;
        Float secondNumber = (float) 0;
        int x = 0;
        Float sum;
        String userInput1 ="Enter the first Number :";
        String userInput2 ="Enter the second Number :";

        //prompt user for 1st input and save the value
        while (x == 0) {
            System.out.println("Enter the first Number :");
            String firstInput = userInput.nextLine();
            try {
                firstNumber = Float.parseFloat(firstInput);
                x++;
            } catch (NumberFormatException e) {
                System.out.println("Sorry you did not enter a valid float");
            }
        }

        while (x == 1) {
            System.out.println("Enter the second number :");
            String secondInput = userInput.nextLine();
            x++;
            try {
                secondNumber = Float.parseFloat(secondInput);
            } catch (NumberFormatException e) {
                System.out.println("Sorry you didn't enter a valid float");
            }
        }

        //prompt the user for there wanted action && return result
        System.out.println("Possible Calculations:\n    (A)dd\n    (S)ubtract\n    (M)ultiply\n    (D)ivide");
        //userInput.nextLine();
        String artimitic = userInput.nextLine();
        String options = "ASMDasmd";

        if (artimitic.length() == 1 && options.contains(artimitic)) {

            if (artimitic.equalsIgnoreCase("A")) {
            sum = add(firstNumber,secondNumber);
            System.out.println(sum);
            }
            else if (artimitic.equalsIgnoreCase("S")) {
            sum = subtract(firstNumber,secondNumber);
            System.out.println(sum);
            }
            else if (artimitic.equalsIgnoreCase("M")) {
            sum = multiply(firstNumber,secondNumber);
            System.out.println(sum);
            }
            else if (artimitic.equalsIgnoreCase("D")) {
            sum = divide(firstNumber,secondNumber);
            System.out.println(sum);
            }
        } else{
            System.out.println("Sorry invalid option");
        }
    }

    public static Float multiply (Float firstNumber,Float secondNumber){
        return (firstNumber * secondNumber);
    }
    public static Float add (Float firstNumber,Float secondNumber){
        return (firstNumber + secondNumber);
    }
    public static Float divide(Float firstNumber, Float secondNumber){
        return (firstNumber/secondNumber);
    }
    public static Float subtract(Float firstNumber,Float secondNumber){
        return (firstNumber - secondNumber);
    }
    public static Float userInputLoop()


}