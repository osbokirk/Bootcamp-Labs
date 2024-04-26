package org.example;

import java.util.Scanner;

public class Main {
    //public static final String ANSI_RESET = ("\u001B[0m");

    //public static final String ANSI_RED_BACKGROUND = ("\u001B[41m");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        while (x == 0) {
            System.out.println("""
                    Which Calculator Would You Like To Use\n
                    1) MORTGAGE CALCULATOR \n 
                    2) FUTURE VALUE CALCULATOR \n
                    3) PRESENT VALUE CALULATOR \n""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Main.mortgageCalc();
                    x++;
                    break;
                case 2:
                    Main.futureValue();
                    x++;
                    break;
                case 3:
                    Main.presentValue();
                    x++;
                    break;
                default:
                    System.out.println("Sorry You Did Not Input a Valid Option :( Try Again\n");
            }
        }
    }

    //calc monthly payment on a loan and how much interest would be paid over the life of the loan
    public static void mortgageCalc(){
        /* Mortgage Calc
            M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
            M = Total monthly payment
            P = The total amount of your loan
            I = Your interest rate, as a monthly percentage
            N = The total amount of months in your timeline for paying off your mortgage
          */
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease Enter Your Loan Lenght In Years");
        int loanLenght = scanner.nextInt() * 12;//in months
        scanner.nextLine();
        System.out.println("Please Enter Your Principal Ammount");
        float principal = scanner.nextFloat();
        System.out.println("Please Enter Your Interest Rate");
        float interestRate = scanner.nextFloat();

        double monthlyPayment = principal*((interestRate/1200 * Math.pow(1+(interestRate/1200),(loanLenght))) /
                (Math.pow(((1 + interestRate/1200)),(loanLenght))-1));
        System.out.print( "Your Monthly Payment Is ");
        System.out.printf("%.2f",monthlyPayment);
        System.out.print(" And You'll Pay A Total Of ");
        System.out.printf("%.2f",((monthlyPayment*loanLenght) - principal));
        System.out.println(" In Interest");
    }

    //takes in a one time deposit and calculated future value total and gives interest accrued
    public static void futureValue(){
        /* FV = P(1 + r/n)^(n*t)
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
        System.out.println(" And You Paid A Total Of :");
        System.out.printf("%.2f",futureValue - principalAmount);
    }

    //determines a present value of a ordinary annuity
    public static void presentValue(){
        /*
            Formula: PV = PMT × [(1 - (1 + r)^(-n)) / r]
            PV is the present value of the annuity.
            PMT is the monthly payout amount.
            r is the monthly interest rate (annual interest rate divided by 12 and then divided by 100 to convert to a decimal).
            n is the total number of monthly payments (number of years to pay out multiplied by 12)
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Monthly Payment");
        double pmt = scanner.nextDouble();
        System.out.println("Please Enter Your Interest Rate");
        double intrestRate = scanner.nextDouble() / 1200;
        scanner.nextLine();
        System.out.println("Please Enter Your Year For The Annuity");
        int years = scanner.nextInt() * 12;

        double formula = pmt * ((1-Math.pow((1 + intrestRate),-years)) / intrestRate);

        System.out.println("The Present Value Of Your Annuity Is");
        System.out.printf("%.2f",formula);
    }
}