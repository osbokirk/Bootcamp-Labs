package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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
        fourInchSub sub = new fourInchSub("White");

        Sandwhich.buildBLT(sub);
        sub.addVeg("Lettuce");
        Order order = new Order();
        order.items.add(sub);
        FileManger.printRecipe(order);

    }


}