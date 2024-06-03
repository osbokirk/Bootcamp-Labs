package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwhichBuilderTest {
    @Test
    @CsvSource({"1,2,3","10,5,15","100,3,103"})
    public void BasicBuilder(){
        //arrange
        //act
        Sandwhich sandwhich = new Sandwhich();
        sandwhich.setBread("Wheat");
        //assert
        assertEquals(sandwhich.getBread(),"Wheat");
    }
    @Test
    @CsvSource({"1,2,3","10,5,15","100,3,103"})
    public void ToppingBuilder(){
        //arrange
        List<String> answer = Arrays.stream(new String[]{"Ham","Turkey"}).toList();
        Sandwhich sub = new Sandwhich();
        sub.setSandwhichSize(SandwhichSize.FOURINCH);
        sub.setBread("White");
        //act
        SandwhichBuilder.addMeats(sub);
        //assert
        assertEquals(sub.meats.keySet(),answer);
    }

}