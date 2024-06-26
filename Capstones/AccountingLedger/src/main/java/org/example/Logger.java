package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private File file = new File("src/main/resources/transactions.csv");
    public static BufferedWriter writer;
    public static BufferedReader reader;
//class responsible for interacting with the csv
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
    }

    public void logDeposit(Transaction transaction)  {
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(file,true))) {
            writer.newLine();
            writer.write(transaction.toString());
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void logWithdraw(Transaction transaction){
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(file,true))) {
            writer.newLine();
            writer.write(transaction.toString());
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void getAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getDeposit(){
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            reader.readLine();


            while ((line = reader.readLine()) != null) {
                String[] lineRead = line.split("\\|");
                if (lineRead[4].contains("-")) {
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println("e");
        }
    }
    public void getPayments(){
        String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            while((line =reader.readLine()) != null){
            //line= reader.readLine();
                String[] lineRead =line.split("\\|");

                if (!lineRead[4] .contains("-")){
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public List<Transaction> returnPayments(){
        List<Transaction> transactions = new ArrayList<>();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] lineRead = line.split("\\|");
                Transaction transaction = new Transaction(lineRead[0],lineRead[1],lineRead[2],lineRead[3],lineRead[4]);
                transactions.add(transaction);
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return transactions;
    }
}
