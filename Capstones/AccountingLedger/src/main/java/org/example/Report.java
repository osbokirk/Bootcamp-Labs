package org.example;

import javax.naming.directory.SearchControls;
import javax.swing.text.DateFormatter;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Report {
    private static List<Transaction> Log;
    private Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

    //reports class is responsible for printing
    //reports based on the creatia of the user
    //below are the most common
    public Report(List<Transaction> log) {
        this.Log = log;
    }
    public void fliterMTD(){
        LocalDate currentDate = LocalDate.now();
        for (int x = Log.size() -1;x>0;x--){
            if (Log.get(x).checkMonth(currentDate.getMonthValue()) && Log.get(x).checkYear(currentDate.getYear())){
                System.out.println(Log.get(x));
            }
        }
    }
    public void filterPrevMonth(){
        LocalDate currentDate = LocalDate.now();
        for (int x = Log.size() -1;x>0;x--){
            if((Log.get(x).getDate().getMonthValue() == currentDate.getMonthValue()-1) && (Log.get(x).getDate().getYear()==currentDate.getYear())){
                System.out.println(Log.get(x));
            }
        }
    }
    public void filterYTD(){
        LocalDate currentDate = LocalDate.now();
        for (int x = Log.size() -1;x>0;x--){
            if (Log.get(x).getDate().getYear() == currentDate.getYear()){
                System.out.println(Log.get(x));
            }
        }
    }
    public void filterPrevYear(){
        LocalDate currentDate = LocalDate.now();
        for (int x = Log.size() -1;x>0;x--){
            if (Log.get(x).getDate().getYear() == currentDate.getYear() - 1 ){
                System.out.println(Log.get(x));
            }
        }
    }
    public void searchVendor(){
        Scanner scanner = new Scanner(System.in);
        String vendor = scanner.nextLine();
        for (int x = Log.size() -1;x>0;x--){
            if (Log.get(x).getVendor().toLowerCase().contains(vendor.toLowerCase())){
                System.out.println(Log.get(x));
            }
        }
    }
    //takes string from customReportInput method to have user
    //build a custom filter
    public void customSearch(String[] inputArray){

        //String[] inputArray = input.split("\\|");
        List<Transaction> customLog = new ArrayList<>();

        for (Transaction x : Log){
            if(!inputArray[0] .equals(" ") && x.getDate().isBefore( LocalDate.parse(inputArray[0],formatter))){
                //customLog.remove(x);
            }else
            if(!inputArray[1] .equals(" ") && x.getDate().isAfter(LocalDate.parse(inputArray[1],formatter))){
                //customLog.remove(x);
            }
            else if(!inputArray[3].equals(" ") && x.getDescription().contains(inputArray[3])){
                //customLog.remove(x);

            }
            else if (!inputArray[4] .equals(" ") && x.getVendor().contains(inputArray[4])){
                //customLog.remove(x);
            }
            else if (!inputArray[2].equals(" ") && x.getPrice() > Double.parseDouble(inputArray[2])){
                //customLog.remove(x);
            }else{
                customLog.add(x);
            }
        }
        for (Transaction x :customLog){
            if(!customLog.contains(x)){

            }

        }
    }
    //takes in all the values for custom search and vets them
    public String customReportInput(){
        String userInput;
        Scanner scanner = new Scanner(System.in);
        TextFormatter c= new TextFormatter();
        System.out.println(c.stringCenter("For Any Of The Below Feild If You Do Not Want To Filter\n" +
                " By Said Category Press Enter To Go To The Next Category"));
        System.out.println(c.stringCenter("What Start Date Do You Want   YYYY MM DD" ));
        String startDate;
        try {
            String dateHolder = scanner.nextLine();
            if (!dateHolder.isEmpty()){
                LocalDate.parse(dateHolder, formatter);
            startDate = dateHolder;
        }else {
                startDate = " ";
            }
        }catch (Exception e){
            startDate= " ";
            System.out.println(c.stringCenter("Sorry We Couldn't Format That Date\nWe Shall Leave It Blank For Now"));
        }
        System.out.println(c.stringCenter("What End Date Do You Want   YYYY MM DD" ));
        String endDate;
        try{
            String dateHolder = scanner.nextLine();
            LocalDate.parse(dateHolder);
            endDate = dateHolder;

        }catch (Exception e){
            endDate = " ";
            System.out.println(c.stringCenter("Sorry We Couldn't Format That Date\nWe Shall Leave It Blank For Now"));
        }
        System.out.println(c.stringCenter("What Amount Would You Like To Search For"));
        String amount;
        try{
            String temp = scanner.nextLine();

            Double.parseDouble(temp);
            amount = temp;
        }catch(NumberFormatException e){
            amount = " ";
            System.out.println(c.stringCenter("Sorry We Couldn't Format That Amount\nWe Shall Leave It Blank For Now"));
        }


        System.out.println(c.stringCenter("Enter The Description You Would Like To Search For" ));
        String description = scanner.nextLine();
        if (description.equals("")){
           description = " ";
        }

        System.out.println(c.stringCenter("Enter Your Vendor You'd Like To Search By"));
        String vendor = scanner.nextLine();
        if (vendor.equals("")){
            description = " ";
        }

        userInput =startDate +"|"+ endDate+"|"+amount+"|"+description+"|"+vendor+"|";
        return userInput;

    }

    public String[] init(){
        TextFormatter c = new TextFormatter();
        String[] output = new String[5];
        output[0] = pullDate();
        output[1] = pullDate();
        output[2] = pullPrice();

        System.out.println(c.stringCenter("Enter The Description You Would Like To Search For" ));
        String description = scanner.nextLine();
        if (description.equals("")){
            description = " ";
        }
        output[3] = description;

        System.out.println(c.stringCenter("Enter The Description You Would Like To Search For" ));
        String vendor = scanner.nextLine();
        if (vendor.equals("")){
            vendor = " ";
        }
        output[4] = vendor;
        return output;
    }
    public String pullPrice(){
        String price = " ";
        TextFormatter c = new TextFormatter();
        System.out.println(c.stringCenter("Please Enter Your Max Price"));
        String temp = scanner.nextLine();
        try{
            Double.parseDouble(temp);
            price = temp;
        }catch (Exception ex){
            System.out.println(c.stringCenter("Sorry Couldn't Understand That we'll skip this for now"));
        }
        return price;
    }
    public String pullDate(){
        String date= " ";
        TextFormatter c= new TextFormatter();
        Scanner scanner = new Scanner(System.in);
        System.out.println(c.stringCenter("Please Enter Your Date    yyyy mm dd"));
        String temp = scanner.nextLine();
        try{
            LocalDate thing = LocalDate.parse(temp,formatter);
            date = temp;
        }catch (Exception ex){
            System.out.println(c.stringCenter("Sorry Couldn't Understand That we'll skip this for now"));
        }
        return date;
    }
    public boolean checkDateTime(Transaction x, String start,String end){
        if (start.equals(" ") && end.equals(" ") ){
            return true;
        }else if(start.equals(" ") && !end.equals(" ")){
            if (x.getDate().isAfter(LocalDate.parse(end))){
                return true;
            }
        }else if(!start.equals(" ") && end.equals(" ")){
            if (x.getDate().isAfter(LocalDate.parse(start))){
                return true;
            }
        }else{
            if(x.getDate().isAfter(LocalDate.parse(start)) && x.getDate().isAfter(LocalDate.parse(end))){
                return true;
            }
        }
        return false;
    }

    public void customReport(String[] input ) {
        for (Transaction x : Log) {
           if (x.getDescription().contains(input[3])
                   && x.getVendor().contains(input[4])
                   && Double.parseDouble(input[2]) < x.getPrice()
                   &&  checkDateTime(x,input[0],input[1])){
               System.out.println(x);
           }
        }

    }

}
