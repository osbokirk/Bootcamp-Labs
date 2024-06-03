package org.example;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class FileMangerTest {
    @Test
    public void testPrintVoid(){
        Order order = new Order();
        System.out.println(LocalDateTime.now());
        FileManger.printRecipe(order);
    }
    @Test
    public void TestPrintFullOrder(){
        Order order = new Order();

        FileManger.printRecipe(order);
    }
    @Test
    public void TestPrintSando(){
        Sandwhich sub = new Sandwhich();

        Sandwhich.buildBLT(sub);
        sub.setBread("Bread");
        sub.addVeg("Lettuce");
        Order order = new Order();
        order.items.add(sub);
        FileManger.printRecipe(order);

    }


}