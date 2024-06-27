package com.example.VehicleBackEnd.Model;

import org.springframework.stereotype.Component;

@Component
public class SalesContractDTO {
    public String date;
    public String customerName;
    public String email;
    public String vin;
    private int termLenght;
    private double salesTaxAmmount;
    private double processingFee;
    private double intrestRate;
    private double monthlyPayment;
    private double totalPrice;
    private boolean isFinanced;
    public SalesContractDTO(String date,String customerName,String email,String vin,int termLenght,double salesTaxAmmount,
                double processingFee,double intrestRate,double monthlyPayment,double totalPrice,boolean isFinanced){
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.vin = vin;
        this.termLenght = termLenght;
        this.salesTaxAmmount = salesTaxAmmount;
        this.processingFee = processingFee;
        this.intrestRate = intrestRate;
        this.monthlyPayment = monthlyPayment;
        this.totalPrice = totalPrice;
        this.isFinanced = isFinanced;
    }
    public SalesContractDTO() {
    }
    public SalesContractDTO(SalesContract contract){
        date = contract.getDate();
        customerName = contract.getCustomerName();
        email = contract.getEmail();
        vin = contract.getVehicleSold().getVin();
        salesTaxAmmount = contract.getSalesTaxAmmount();
        processingFee = contract.getProcessingFee();
        isFinanced = contract.isFinanced();
        intrestRate = contract.getIntrestRate();
        termLenght = contract.getTermLenght();
        monthlyPayment = contract.getMonthlyPayment();
        totalPrice = contract.getTotalPrice();
    }


    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getVin() {
        return vin;
    }

    public double getSalesTaxAmmount() {
        return salesTaxAmmount;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public double getIntrestRate() {
        return intrestRate;
    }

    public int getTermLenght() {
        return termLenght;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
