package org.example;

import javax.naming.directory.SearchControls;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Report {
    private static List<Transaction> Log;
    private Scanner scanner = new Scanner(System.in);

    public Report(List<Transaction> log) {
        Log = log;
    }
    public void fliterMTD(){
        LocalDate currentDate = LocalDate.now();
        for(Transaction x:Log){
            if (x.checkMonth(currentDate.getMonthValue()) && x.checkYear(currentDate.getYear())){
                System.out.println(x.toString());
            }
        }
    }
    public void filterPrevMonth(){
        LocalDate currentDate = LocalDate.now();
        for (Transaction x: Log){
            if((x.getDate().getMonthValue() == currentDate.getMonthValue()-1) && (x.getDate().getYear()==currentDate.getYear())){
                System.out.println(x);
            }
        }
    }
    public void filterYTD(){
        LocalDate currentDate = LocalDate.now();
        for(Transaction x:Log){
            if (x.getDate().getYear() == currentDate.getYear()){
                System.out.println(x);
            }
        }
    }
    public void filterPrevYear(){
        LocalDate currentDate = LocalDate.now();
        for(Transaction x:Log){
            if (x.getDate().getYear() == currentDate.getYear() - 1 ){
                System.out.println(x);
            }
        }
    }
    public void searchVendor(){
        Scanner scanner = new Scanner(System.in);
        String vendor = scanner.nextLine();
        for (Transaction x: Log){
            if (x.getVendor().toLowerCase().contains(vendor.toLowerCase())){
                System.out.println(x);
            }
        }
    }

    public void customSearch(LocalDate startDate,LocalDate endDate,String description,String vendor,double price){
        List<Transaction> customLog = Log;
        for (Transaction x : customLog){
            if(startDate != null && x.getDate().isBefore( startDate)){
                customLog.remove(x);
            }
            if(endDate != null && x.getDate().isBefore(endDate)){
                customLog.remove(x);
            }
            if(description != null && x.getDescription().contains(description)){
                customLog.remove(x);
            }
            if (vendor != null && x.getVendor().contains(vendor)){
                customLog.remove(x);
            }
            if (price != 0  && x.getPrice() > price){
                customLog.remove(x);
            }
        }
        for (Transaction x :customLog){
            System.out.println(x);
        }
    }

}
