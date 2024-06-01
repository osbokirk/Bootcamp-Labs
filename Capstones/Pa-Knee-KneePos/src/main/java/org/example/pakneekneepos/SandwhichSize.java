package org.example.pakneekneepos;

public enum SandwhichSize {
    FOURINCH(5.00,1.00,0.50,0.75,0.30)
    ,EIGHTINCH(7.00,2.00,1.00,1.50,0.60)
    ,TWELVEINCH(8.50,3.00,1.50,2.25,0.90);

    private double base;
    private double meat;
    private double extraMeat;
    private double cheese;
    private double extraCheese;

    SandwhichSize(double v, double v1, double v2, double v3, double v4) {
    base =v;
    meat = v1;
    extraMeat = v2;
    cheese =v3;
    extraCheese = v4;
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
