package org.example;

public class TextFormatter {
    public TextFormatter() {
    }

    public String stringCenter(String text){
        int spacing =(60 - text.length()) / 2;
        String buffer = " ";
        for (int x = 1;x < spacing;x++){
            System.out.print(" ");
        }

        return text;
    }
    public void changeColor(){

    }
    public void changeStyle(){

    }
}
//Collections.sort(transactions, Comparator.comparing(Transaction::getDate))