package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwhichTest {
    @Test
    public void smallSub(){
        //arrange
        fourInchSub sub = new fourInchSub("White");
        //act
        sub.addMeat("Ham");
        sub.addMeat("Ham");
        sub.addCheese("Swiss");
        sub.addCheese("Swiss");
        sub.addSauses("Soy");
        sub.addVeg("Onion");
        //
        assertEquals(8.05,sub.getPrice());

    }
    @Test
    public void meduiumSub(){
        //arrange
        eightInchSub sub = new eightInchSub("White");
        //act
        sub.addMeat("Ham");
        sub.addMeat("Ham");
        //sub.addMeat("Turkey");
        sub.addCheese("Swiss");
        sub.addCheese("Swiss");
        sub.addSauses("Soy");
        sub.addVeg("Onion");
        // assert
        assertEquals(12.1,sub.getPrice());
    }
    @Test
    public void LargeSub(){
        //arrange
        twelveInchSub sub = new twelveInchSub("White");
        //act
        sub.addMeat("Ham");
        sub.addMeat("Ham");
        //sub.addMeat("Turkey");
        sub.addCheese("Swiss");
        sub.addCheese("Swiss");
        sub.addSauses("Soy");
        sub.addVeg("Onion");
        // assert
        assertEquals(16.15,sub.getPrice());

    }

}