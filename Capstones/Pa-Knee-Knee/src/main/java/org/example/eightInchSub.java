package org.example;

public class eightInchSub extends Sellable implements Sandwhich{
    private static final double BasePrice = 7.0;
    private static final double meatPrice = 2.0;
    static final double extraMeat = 1.0;
    private static final double cheesePrice = 1.5;
    static final double extraCheese = .60;
    private String bread;

    public eightInchSub(String bread) {
        this.bread = bread;
    }

    public double getPrice() {
        double total  = BasePrice;
        int meatCount = (int) this.meats.values().stream().count();
        if(meatCount >= 1){total += meatPrice + (meatCount - 1) * extraMeat;}
        int cheeseCount = (int) this.cheese.values().stream().count();
        if(cheeseCount >= 1){total += cheesePrice + (cheeseCount -1) * extraCheese;}
        return total;
    }
}
