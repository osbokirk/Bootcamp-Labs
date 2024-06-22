package com.example.VehicleBackEnd.Model;

import org.springframework.stereotype.Component;

@Component
public class SalesContractDTO {
    public String date;
    public String customerName;
    public String email;
    public String vin;
    private double salesTaxAmmount;
    private double processingFee;
    private boolean isFinanced;
    private double intrestRate;
    private int termLenght;
    private double monthlyPayment;
    private double totalPrice;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getSalesTaxAmmount() {
        return salesTaxAmmount;
    }

    public void setSalesTaxAmmount(double salesTaxAmmount) {
        this.salesTaxAmmount = salesTaxAmmount;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public double getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(double intrestRate) {
        this.intrestRate = intrestRate;
    }

    public int getTermLenght() {
        return termLenght;
    }

    public void setTermLenght(int termLenght) {
        this.termLenght = termLenght;
    }
}
