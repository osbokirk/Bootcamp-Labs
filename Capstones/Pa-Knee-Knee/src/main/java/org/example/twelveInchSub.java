package org.example;

public class twelveInchSub extends  Sandwhich implements Sellable{
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
