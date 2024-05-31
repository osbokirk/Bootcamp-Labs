package org.example;

import javax.swing.text.DateFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class FileManger {
    public static void printRecipe(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String time = LocalDateTime.now().format(formatter);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + time + ".txt"))) {
           String s ;
            //order.items.stream().forEach(x -> s.concat(x.toString()));
            String test = order.items.get(0).toString();
            writer.write(order.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
