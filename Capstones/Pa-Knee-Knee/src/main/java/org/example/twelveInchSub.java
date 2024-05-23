package org.example;

public class twelveInchSub extends Sellable implements Sandwhich{
    private static final double BasePrice = 8.50;
    private static final double meatPrice = 3.0;
    static final double extraMeat = 1.5;
    private static final double cheesePrice = 2.25;
    static final double extraCheese = .90;
    private String bread;

    public twelveInchSub(String bread) {
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
