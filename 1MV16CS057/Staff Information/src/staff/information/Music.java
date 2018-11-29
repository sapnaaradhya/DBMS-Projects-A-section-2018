/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff.information;

import com.sun.media.sound.*;
import java.io.*;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.*;

/**
 *
 * @author Nasir Basha K
 */
public class Music {

    public static void main(String[] args) throws IOException {
  musicPlayer("C:\\Users\\Nasir Basha K\\Desktop\\DBMS Staff Info\\1MV16CS057\\Staff Information\\src\\audiofiles\\audio1.wav");
    }
    
    
    
    
    
    public static void musicPlayer(String filepath) throws FileNotFoundException, IOException{
        
              try{
 InputStream music = new FileInputStream(new File(filepath));
       
        AudioStream audio = new AudioStream(music); 
        AudioPlayer.player.start(audio);
        
        }
        catch(Exception e){
            
        }
        
    }
    
    
    
    
    
    

    public static void audio() {

        AudioPlayer ap = AudioPlayer.player;
        AudioStream as;
        AudioData ad;

        ContinuousAudioDataStream stream = null;

        try {

            //File starting = new File(System.getProperty("user.dir"));
            //File fileToBeRead = new File(starting, "a1.wav");
             String bip = "C:\\Users\\Nasir Basha K\\Desktop\\Dbms Test\\short_guitar.mp3";
             Media hit = new Media(new File(bip).toURI().toString());
             MediaPlayer mediaPlayer = new MediaPlayer(hit);
             mediaPlayer.play();
            as = new AudioStream(new FileInputStream("C:\\\\Users\\\\Nasir Basha K\\\\Desktop\\\\Dbms Test\\\\short_guitar.mp3"));
            ad = as.getData();
            stream = new ContinuousAudioDataStream(ad);
            ap.start();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
