package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Calculator Would You Like To Use"+
                "\n 1) MORTGAGE CALCULATOR \n 2) FUTURE VALUE CALCULATOR "+
                "\n 3) PRESENT VALUE CALULATOR (CURRENTLY UNAVALIBLE)");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                Main.mortgageCalc();
                break;
            case 2:
                Main.futureValue();
                break;
            case 3:
                //Main.presentValue();
                System.out.println("Sorry Our Present Value Calculator Is Out Of Order Currently");
                break;
            default:
                System.out.println("Sorry You Did Not Input a Valid Option :( GOODBYE");
        }
    }
    public static void mortgageCalc(){
        /*
        calc monthly payment on a loan and how much interest would be paid over the life of the loan
            *takes in principal,interest rate,and loanLenght
            *outputs expected monthlyPayments and total interest paid

            Mortgage Calc
            M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
            M = Total monthly payment
            P = The total amount of your loan
            I = Your interest rate, as a monthly percentage
            N = The total amount of months in your timeline for paying off your mortgage
          */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Loan Lenght In Years");
        int loanLenght = scanner.nextInt() * 12;//in months
        scanner.nextLine();

        System.out.println("Please Enter Your Principal Ammount");
        float principal = scanner.nextFloat();

        float interestRate = 07.625f; //scanner.nextFloat();


        double monthlyPayment = principal*((interestRate/1200 * Math.pow(1+(interestRate/1200),(loanLenght))) /
                (Math.pow(((1 + interestRate/1200)),(loanLenght))-1));


        System.out.printf("%.2f",monthlyPayment);
        System.out.println();
        System.out.printf("%.2f",((monthlyPayment*loanLenght) - principal));
    }
    public static void futureValue(){
        /*
        takes in a one time deposit and calculated future value total and gives interest accrued
            *takes in a deposit, interest rate, and number of years
            *outputs the future value and the total interest earned

            FV = P(1 + r/n)^(n*t)

            FV is the future value of the deposit.
            P is the initial deposit amount.
            r is the annual interest rate (in decimal form, e.g., 0.0175 for 1.75%).
            n is the number of times the interest is compounded per year (assuming daily compounding, n would be 365).
            t is the number of years the money is invested for.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter your intial deposit ammount");
        double principalAmount = scanner.nextDouble();

        System.out.println("Please enter your intrest rate as a %");
        double interestRate = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("how long will you be investing for");
        int numberOfYears = scanner.nextInt();//whole number

        int n = 365;//days of the year
        double newInterestRate = (interestRate /100)/n;


        double futureValue = principalAmount*Math.pow((1+(newInterestRate)),(n * numberOfYears));
        System.out.println("Your Future Value Will Be : ");
        System.out.printf("%.2f",futureValue);
        System.out.println("And You Paid A Total Of :");
        System.out.printf("%.2f",futureValue - principalAmount);

    }
    public static void presentValue(){
        /*
        determines a present value of a ordinary annuity
            *accepts monthly payout, expected interest rate, years to payout
            *outputs present value of the annuity

           Formula: PV = PMT × [(1 - (1 + r)^(-n)) / r]

           PV is the present value of the annuity.
           PMT is the monthly payout amount.
           r is the monthly interest rate (annual interest rate divided by 12 and then divided by 100 to convert to a decimal).
           n is the total number of monthly payments (number of years to pay out multiplied by 12).
         */

        System.out.println();

    }

}