package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private File file = new File("src/main/resources/transactions.csv");
    public static BufferedWriter writer;
    public static BufferedReader reader;

    public Logger() {
        try {
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file,true);
            reader = new BufferedReader(fileReader);
            writer = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("i ran");
    }

    public void logDeposit(Transaction transaction)  {
        try {
            this.writer.write(transaction.toString());
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void logWithdraw(Transaction transaction){
        try{
            Logger.writer.write(transaction.toString());
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void getAll() {
        /*


        String line;

        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) ;
            String[] lineRead = line.split("\\|");
            if (!lineRead[4].contains("-")) {
                System.out.println(line);
            }
        }catch (IOException e){

        }
    }*/
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                //String[] productInfo = line.split("\\|");
                //int id = Integer.parseInt(productInfo[0]);
                //String name = productInfo[1];
               // double price = Double.parseDouble(productInfo[2].replace(",", ""));
                //String category = productInfo[3];
                //Product product = new Product(id, name, price, category);
                //inventory.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getDeposit(){

        String line;
        try {
            while ((line = reader.readLine()) != null) ;
            String[] lineRead = line.split("|");
            if (!lineRead[4].contains("-")) {
                System.out.println(line);
            }
        }catch (IOException e){

        }
    }
    public void getPayments(){
        String line;
        try{
            line= reader.readLine();
            String[] lineRead =line.split("|");
            if (!lineRead[4] .contains("-")){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public List<Transaction> returnPayments(){
        List<Transaction> transactions = new ArrayList<>();
        String line;
        try {
            reader.readLine();

            while ((line = reader.readLine()) != null) ;
            String[] lineRead = line.split("|");
            Transaction transaction = new Transaction(lineRead[0],lineRead[1],lineRead[2],lineRead[3],lineRead[4]);
            transactions.add(transaction);
        }catch (IOException e){

        }
        return transactions;
    }
}
