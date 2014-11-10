/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

    import  sun.audio.*;    //import the sun.audio package
    import  java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class Music {
    

    //** add this into your application code as appropriate
    // Open an input stream  to the audio file.
    InputStream in;
    // Create an AudioStream object from the input stream.
    AudioStream as;      
    AudioData data;
    // Create ContinuousAudioDataStream.
    ContinuousAudioDataStream cas;

    public Music(String fileName) throws IOException
    {
        try {
            in = new FileInputStream("sounds/"+fileName+".wav");
            as = new AudioStream(in);
            //data = as.getData();
            //cas = new ContinuousAudioDataStream (data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void startSound()
    {
        AudioPlayer.player.start(as);  
    }
    public void stopSound()
    {
        AudioPlayer.player.stop(as);
    }
    
}
