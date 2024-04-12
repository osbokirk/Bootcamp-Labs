package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*get pickupdate, number of days, whether toll tag, gps or roadside assistance age

        Introduce user to app
        prompt & ask user for age - int
        prompt & ask user for toll tag - boolean
        prompt & ask user for gps - boolean
        prompt & ask user for roadside assistance - boolean


        calc avg daily rate and return it to user

        prompt & ask user for pickup date - string
        prompt & ask user for number of days - int(round up)
        return total to customer
        */
//        Introduce user to app
        Scanner userInput = new Scanner(System.in);
        float customerDailyRate = 29.99f;
        float upchargeBasic = 2.95f;
        float upchargePremium = 3.95f;
        float agePremium = 1.3f;
        String pickUpDate;
        int numberOfDays;
        float sum;
        int x = 0;




        System.out.println("Hello welcome to the Rental Car App\n" +
                "We'll need some info to calculate your daily rate:");
//        prompt & ask user for age add sercharge - int
        System.out.println("Thank you for that information before we get able to get your rate we just need you to enter your age");
        if (userInput.nextInt()<25){
            customerDailyRate *= agePremium;
        }
        userInput.nextLine();

        // Prompt users for add-ons
        System.out.println("to get started would you toll tag for your vehicle              y/n");
        while (x == 0) {
            String userString = userInput.next();
            switch (userString.toLowerCase()) {
                case "y":
                    customerDailyRate += upchargePremium;
                    x++;
                    break;
                case "n":
                    x++;
                    break;
                default:
                    System.out.println("Sorry user Input invalid");
            }
        }
        System.out.println("next up would you like GPS Navigation              y/n");
        while (x == 1) {
            String userString = userInput.next();
            switch (userString.toLowerCase()) {
                case "y":
                    customerDailyRate += upchargeBasic;
                    x++;
                    break;
                case "n":
                    x++;
                    break;
                default:
                    System.out.println("Sorry user Input invalid");
            }
        }
        System.out.println("And would you like roadside Assistance              y/n");
        while (x == 2) {
            String userString = userInput.next();
            switch (userString.toLowerCase()) {
                case "y":
                    customerDailyRate += upchargePremium;
                    x++;
                    break;
                case "n":
                    x++;
                    break;
                default:
                    System.out.println("Sorry user Input invalid");
            }
        }
        userInput.nextLine();
        /*
        switch (userInput.nextLine()){
            case "y":
                customerDailyRate += upchargePremium;
                System.out.println("Great");
                break;
            default:
                System.out.println("OK");
        }
        */

//
//        return avg daily rate and return it to user
        System.out.println("Your average daily rate should be: "+ customerDailyRate);
//
//        prompt & ask user for pickup date - string
        System.out.println("What date would you like to like us to have your car ready for you     mm/dd/yyyy");
//        prompt & ask user for number of days - int(round up)
        pickUpDate = userInput.nextLine();
        System.out.println("Great and how many days will you be needing the vehilce for");
        numberOfDays = userInput.nextInt();
        userInput.nextLine();
//        return total to customer
        sum = numberOfDays * customerDailyRate;
        System.out.println("Great! Your rental total for "+ numberOfDays + " days will be "+ sum +" and will be ready on " + pickUpDate);

    }
}