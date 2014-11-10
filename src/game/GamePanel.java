/*
Changelog
=====================

*/

package game;

import core.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import settings.Setting;
import util.XML_240;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class GamePanel extends JPanel
{
    /**
     * Constructor for the class
     * @since version 1.00
     */
    public JButton back;
    public int width, height;
    Setting music, difficulty, resolution;
    JLabel difficultyL, resolutionL, musicL;
    Music psuMedly;
    public GamePanel(int width, int height)
    {
        super();
        try {
            psuMedly = new Music("fightOn");
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.width = width;
        this.height = height;
        setBackground(Color.gray);
        setLayout(null);
        back = new JButton("Main Menu");
        add(back);
        loadSettings();
        difficultyL = new JLabel("Difficulty: " + difficulty.getSettingValue());
        resolutionL = new JLabel("Resolution: " + resolution.getSettingValue());
        musicL = new JLabel("Music: " + music.getSettingValue());
        musicL.setFont(musicL.getFont().deriveFont(20.0f));
        resolutionL.setFont(resolutionL.getFont().deriveFont(20.0f));
        difficultyL.setFont(difficultyL.getFont().deriveFont(20.0f));
        add(musicL);
        add(difficultyL);
        add(resolutionL);
        
        
    }
    public Music getMusic()
    {
        return this.psuMedly;
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        back.setBounds(new Rectangle((width/2)-100,(height/4*3)-50,200, 50));
        difficultyL.setBounds(new Rectangle((width/4)-50, (height/2)-100, 200, 25));
        musicL.setBounds(new Rectangle((width/4*2)-50, (height/2)-100, 100, 25));
        resolutionL.setBounds(new Rectangle((width/4*3)-50, (height/2)-100, 300, 25));
        difficultyL.setText("Difficulty: " + difficulty.getSettingValue());
        resolutionL.setText("Resolution: " + resolution.getSettingValue());
        musicL.setText("Music: " + music.getSettingValue());
    }
    /**
     * Read the resolution, difficulty, and music settings from file.
     */
    public void loadSettings()
    {
        XML_240 x2 = new XML_240();
        x2.openReaderXML("Options.xml");
        resolution = (Setting)x2.ReadObject();
        difficulty = (Setting)x2.ReadObject();
        music = (Setting)x2.ReadObject();
        x2.closeReaderXML();
        
    }

	
}
