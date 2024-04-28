package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayer {
   public static void   playJams(){
    Scanner scanner  = new Scanner(System.in);
    File file = new File("src/main/resources/Music.wav");
    AudioInputStream audioStream;
    try{
        audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();

        clip.open(audioStream);
        clip.loop(100);
        // should change to a whileloop that checks the system condition

        //String responce = scanner.next();
    }catch(UnsupportedAudioFileException x){
        throw new RuntimeException(x);
    } catch(IOException y){
        throw new RuntimeException(y);
    }catch (NullPointerException z){
        throw new NullPointerException();
    } catch (LineUnavailableException e) {
        throw new RuntimeException(e);
    }


   }
}
