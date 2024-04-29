package org.example;

import java.util.Scanner;

public class Screen {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = new Logger();

    public static void main(){
        System.out.println("""
                                
                                Would You Like To 
                                D) Make Deposit
                                P) Make A Payment
                                L) Ledger
                                X) EXIT
        """);
        mainSwitch(scanner.next());
    }
    public static void mainSwitch(String input){
        switch (input.toUpperCase()){
            case "D":
                //logger.add(Transacion.newDeposit);
            case "P":
                //logger.add(Transaction.newWithdraw);
            case "L":
                System.out.println("Great Choice!");
                ledger();
            case "X":
                System.exit(0);
            default:
                System.out.println("");
        }
    }
    public static void ledger(){
        System.out.println("""
                What Ledger Can I Get For You
                A) ALL
                D) Deposits
                P) Payments
                R) Reports
                H) Home
                """);
        ledgerSwitch(scanner.next());
    }
    public static void ledgerSwitch(String input){
        switch (input.toUpperCase()){
            case "A":
                //logger.getAll
            case "D":
                //loger.getDeposits
            case "P":
                //loger.getPayments
            case "R":
                System.out.println("All Righty I Have All The Reports Prepped Which One Do You Need");
                reports();
            case "H":
                main();
            default:
                System.out.println("Sorry I Do Not Think I Can Get That, Try Again");
                ledger();
        }
    }

    public static void reports(){
        System.out.println("""
                1) Month To Date
                2) Previous Month
                3) Year To Date
                4) Previous Year
                5)Search by Vendor
                6) Custom Search
                0) Back
                """);
       Integer input =  Integer.parseInt(scanner.next());
       switch (input){
           case 1:
           case 2:
           case 3:
           case 4:
           case 5:
           case 6:
           case 0:
           default:
               System.out.println("Sorry I Done Have That Report But I Have");
               reports();
       }

    }
}
