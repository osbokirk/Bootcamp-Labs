package org.example;

public enum SandwhichSize {
    FOURINCH(5.50,1.00,0.50,0.75,0.30,"Four Inch")
    ,EIGHTINCH(7.00,2.00,1.00,1.50,0.60,"Eight Inch")
    ,TWELVEINCH(8.50,3.00,1.50,2.25,0.90,"Twelve Inch");

    private double base;
    private double meat;
    private double extraMeat;
    private double cheese;
    private double extraCheese;
    private String size;

    public String getSize() {
        return size;
    }

    SandwhichSize(double v, double v1, double v2, double v3, double v4, String v5) {
    base =v;
    meat = v1;
    extraMeat = v2;
    cheese =v3;
    extraCheese = v4;
    size = v5;
    }

    public double getBase() {
        return base;
    }

    public double getMeat() {
        return meat;
    }

    public double getExtraMeat() {
        return extraMeat;
    }

    public double getCheese() {
        return cheese;
    }

    public double getExtraCheese() {
        return extraCheese;
    }
}
