package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private Double price;

    public Transaction(String date, String time, String description, String vendor, String price) {


        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time) ;
        this.description = description;
        this.vendor = vendor;
        this.price = Double.parseDouble(price);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean checkYear(int year){
        if (this.date.getYear() == year){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkMonth(int month){
        if (this.date.getMonthValue() == month){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String value = date +"|"+ time+ "|"+description+"|"+vendor+"|"+price;
        return value;
    }
}
