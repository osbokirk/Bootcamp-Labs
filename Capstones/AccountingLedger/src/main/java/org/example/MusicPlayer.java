package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    private static String[] jukeBox = {"src/main/resources/BackgroundMusic.wav","src/main/resources/Reports.wav","src/main/resources/Transition.wav","src/main/resources/Transition2.wav"};

    //Class is responsible for playing existing
    // Music and SFX from provided array
    public static void playMusic(){
        File file = new File(jukeBox[0]);
        AudioInputStream audioStream;
        try{
            audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(100);
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
    public static void sound(int index){
        File file = new File(jukeBox[index]);
        AudioInputStream audioStream;
        try{
            audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
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
