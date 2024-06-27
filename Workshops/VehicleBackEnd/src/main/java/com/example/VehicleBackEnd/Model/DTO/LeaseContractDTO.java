package com.example.VehicleBackEnd.Model;

import org.springframework.stereotype.Component;

@Component
public class LeaseContractDTO {
    public String date;
    public String customerName;
    public String email;
    public String Vin;
    public double totalPrice;
    public double monthlyPayment;
    public double endingValue;
    public double leaseFeeCharge;
    public double intrestRate ;//4%



    public LeaseContractDTO(LeaseContract contract) {
        date = contract.getDate();
        customerName = contract.getCustomerName();
        email = contract.getEmail();
        Vin = contract.getVehicleSold().getVin();
        totalPrice = contract.getTotalPrice();
        monthlyPayment = contract.getMonthlyPayment();
        endingValue = contract.getEndingValue();
        leaseFeeCharge = contract.getLeaseFeeCharge();
        intrestRate = contract.getIntrestRate();
    }
    public LeaseContractDTO(){}

    public LeaseContractDTO(String date, String customerName, String email, double totalPrice, double monthlyPayment, double endingValue, double leaseFeeCharge, double intrestRate,  String vin) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        this.endingValue = endingValue;
        this.leaseFeeCharge = leaseFeeCharge;
        this.intrestRate = intrestRate;
        this.Vin = vin;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public double getLeaseFeeCharge() {
        return leaseFeeCharge;
    }

    public double getIntrestRate() {
        return intrestRate;
    }



    public String getVin() {
        return Vin;
    }
}
