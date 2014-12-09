/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import  java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jack
 */
public class Music {
    

    AudioInputStream ais;
    Clip clip;
    String fileName;

    /**
     * Constructor for the music class.
     * Creates an audio stream from a sound file.
     * @param fileName
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public Music(String fileName) throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        try {
            this.fileName = fileName;
            ais = AudioSystem.getAudioInputStream(new File("src/sounds/"+this.fileName+".wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Starts the sound.
     * All sounds used are background music so it loops them.
     * If it's the menu music "hey" it sets the loop so it doesn't pause at the end
     * Otherwise it sets the loop points as the beginning and end.
     */
    public void startSound()
    {
        clip.loop(LOOP_CONTINUOUSLY);
        if(fileName.equalsIgnoreCase("hey"))
        {
            clip.setLoopPoints(0, 2835000);
        }
        else
        {
            clip.setLoopPoints(0, -1);
        }
    }

    /**
     * Stops the looping music and resets it to the begining.
     */
    public void stopSound()
    {
        clip.stop();
        clip.setFramePosition(0);
    }
    
}
