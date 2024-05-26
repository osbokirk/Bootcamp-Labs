package org.example;

public class eightInchSub  extends Sandwhich implements Sellable{
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
        int meatCount = (int) this.meats.values().stream().mapToDouble(value -> value).sum();
        if(meatCount >= 1){total += meatPrice + (meatCount - 1) * extraMeat;}
        int cheeseCount = (int) this.cheeses.values().stream().mapToDouble(value -> value).sum();
        if(cheeseCount >= 1){total += cheesePrice + (cheeseCount -1) * extraCheese;}
        return total;
    }
    public String toString(){
        String s = "8 Inch Sub \n"+super.toString() + getPrice();
        return s;
    }
}
