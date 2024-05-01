package org.example;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = new Logger();
    private static TextFormatter textFormatter= new TextFormatter();
    private static Report r = new Report(logger.returnPayments());

    public static void Init(){
        MusicPlayer.playMusic();
        System.out.println("""
                
                   ▄▄▄▄▄   █     ▄███▄   ▄███▄   █ ▄▄  █     ▄███▄     ▄▄▄▄▄    ▄▄▄▄▄ \s
                  █     ▀▄ █     █▀   ▀  █▀   ▀  █   █ █     █▀   ▀   █     ▀▄ █     ▀▄
                ▄  ▀▀▀▀▄   █     ██▄▄    ██▄▄    █▀▀▀  █     ██▄▄   ▄  ▀▀▀▀▄ ▄  ▀▀▀▀▄ \s
                 ▀▄▄▄▄▀    ███▄  █▄   ▄▀ █▄   ▄▀ █     ███▄  █▄   ▄▀ ▀▄▄▄▄▀   ▀▄▄▄▄▀  \s
                               ▀ ▀███▀   ▀███▀    █        ▀ ▀███▀                    \s
                                                   ▀                                  \s
                                                                                      \s
                               ▄▄▄▄▄   ████▄   ▄   █      ▄▄▄▄▄                       \s
                              █     ▀▄ █   █    █  █     █     ▀▄                     \s
                            ▄  ▀▀▀▀▄   █   █ █   █ █   ▄  ▀▀▀▀▄                       \s
                             ▀▄▄▄▄▀    ▀████ █   █ ███▄ ▀▄▄▄▄▀    \s       \s
                  """ );
        main();
    }

    public static void main(){
        //MusicPlayer.playMusic();
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
                logger.logDeposit(new Transaction("+"));
                break;
            case "P":
                logger.logWithdraw(new Transaction("-"));
                break;
            case "L":
                MusicPlayer.sound(1);
                System.out.println(textFormatter.stringCenter("Great Choice!"));
                ledger();
                break;
            case "X":
                System.exit(0);
                break;
            default:
                System.out.println("");
        }
        main();
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
        MusicPlayer.sound(3);
        main();
    }
    public static void ledgerSwitch(String input){
        switch (input.toUpperCase()){
            case "A":
                logger.getAll();
                break;
            case "D":
                logger.getDeposit();
                break;
            case "P":
                logger.getPayments();
                break;
            case "R":
                MusicPlayer.sound(1);
                System.out.println(textFormatter.stringCenter("All Righty I Have All The Reports Prepped Which One Do You Need"));
                reports();
                break;
            case "H":
                MusicPlayer.sound(3);
                main();
                break;
            default:
                System.out.println(textFormatter.stringCenter("Sorry I Do Not Think I Can Get That, Try Again"));
                ledger();
        }
    }

    public static void reports(){
        System.out.println("""
                            1) Month To Date
                            2) Previous Month
                            3) Year To Date
                            4) Previous Year
                            5) Search by Vendor
                            6) Custom Search
                            0) Back
        """);
        System.out.println(textFormatter.stringCenter("Please Select A Option"));
       Integer input =  Integer.parseInt(scanner.next());
       Report report = new Report(logger.returnPayments());
       switch ((input)){

           case 1:
               report.fliterMTD();
               break;
           case 2:
               report.filterPrevMonth();
               break;
           case 3:
               report.filterYTD();
               break;
           case 4:
               report.filterPrevYear();
               break;
           case 5:
               System.out.println(textFormatter.stringCenter("Enter The Name Of The Vendor Your Searching For"));
               //String vendor = scanner.nextLine();
               report.searchVendor();
               break;
           case 6:


               //report.customSearch();
               System.out.println(textFormatter.stringCenter("I lOsT ThAt ONe"));
               break;
           case 0:
               MusicPlayer.sound(3);
               ledger();
               break;
           default:
               System.out.println(textFormatter.stringCenter("Sorry I Do Not Have That Report, But I Have"));
               reports();
       }
        reports();
    }

}
