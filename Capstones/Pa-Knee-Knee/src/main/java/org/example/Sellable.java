package org.example;

public interface Sellable {
    public default double getPrice(){
        return 0;
    }
}
