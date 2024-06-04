package org.example.pakneekneepos;

public interface Sellable {
    public default double getPrice(){
        return 0;
    }
}
