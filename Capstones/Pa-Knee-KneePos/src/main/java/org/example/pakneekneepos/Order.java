package org.example.pakneekneepos;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Sellable> items = new ArrayList<>();
    public String toString(){
        String output = "";
        for(Sellable item : items){
            output = output + item.toString()+"\n";
        }
    return output;
    }
}
