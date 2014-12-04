/*
Changelog
=====================
19 October 2014
    -1600 hours
        *initial creation
20 October 2014
    -0400
        *added rollCredits JButton, this is to temporarily show the credits are working
*/

package core;

import game.Music;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import settings.Setting;
import util.XML_240;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class SplashPanel extends JPanel
{

    JButton creditsButton, startGame, instructionsButton, settingsButton;
    Music hey;
    Setting music, resolution;
    XML_240 x2;
    public int HEIGHT = 0, WIDTH = 0;
    /**
     * Constructor for the class
     * @param height Height of the parent JFrame
     * @param width Width of the parent JFrame
     * @since version 1.00
     */
    public SplashPanel(int height, int width)
    {
        super();
        try {
            hey = new Music("hey");
        } catch (IOException ex) {
            Logger.getLogger(SplashPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        x2 = new XML_240();
        setLayout(null);
        HEIGHT = height;
        WIDTH = width;
        //button creation
        creditsButton = new JButton("Credits");
        startGame = new JButton("Start Game!");
        instructionsButton = new JButton("Instructions");
        settingsButton = new JButton("Settings");
        //adding buttons to panel
        add(creditsButton);
        add(startGame);
        add(instructionsButton);
        add(settingsButton);
        //setting locations of buttons
        //Rectangle(x,y,length,height)
        creditsButton.setBounds(new Rectangle(WIDTH-125, HEIGHT-100, 100, 50));
        startGame.setBounds(new Rectangle(((WIDTH/2)-100), ((HEIGHT/2)-100), 200, 50));
        instructionsButton.setBounds(new Rectangle(((WIDTH/3*2)-100), ((HEIGHT/3*2)-100), 200, 50));
        settingsButton.setBounds(new Rectangle(((WIDTH/3)-100), ((HEIGHT/3*2)-100), 200, 50));
        setBackground(Color.gray);
        loadMusic();
    }
    public Music getMusic()
    {
        return this.hey;
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        creditsButton.setBounds(new Rectangle(WIDTH-125, HEIGHT-100, 100, 50));
        startGame.setBounds(new Rectangle(((WIDTH/2)-100), ((HEIGHT/2)-100), 200, 50));
        instructionsButton.setBounds(new Rectangle(((WIDTH/3*2)-100), ((HEIGHT/3*2)-100), 200, 50));
        settingsButton.setBounds(new Rectangle(((WIDTH/3)-100), ((HEIGHT/3*2)-100), 200, 50));
    }
    public void loadMusic()
    {
        x2.openReaderXML("Options.xml");
        resolution = (Setting)x2.ReadObject();
        x2.ReadObject();
        music = (Setting)x2.ReadObject();
        x2.closeReaderXML();
        
        if(music.getSettingValue().equalsIgnoreCase("on"))
        {
            hey.startSound();
        }
        else
        {
            hey.stopSound();
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image bg_big = Toolkit.getDefaultToolkit().getImage("images/menuBG_big.jpg");
        Image bg_med = Toolkit.getDefaultToolkit().getImage("images/menuBG_med.jpg");
        Image bg_sm = Toolkit.getDefaultToolkit().getImage("images/menuBG_sm.jpg");
        switch(resolution.getSettingValue())
        {
            case "1200 x 1000":
                g.drawImage(bg_big, 0, 0, this);
                break;
            case "1000 x 800":
                g.drawImage(bg_med, 0, 0, this);
                break;
            case "800 x 600":
                g.drawImage(bg_sm, 0, 0, this);
                break;
        }
        
    }


	
}
