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

import credits.Credits;
import credits.CreditsPanel;
import game.GamePanel;
import instructions.InstructionsPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import settings.Setting;
import settings.SettingsPanel;
import util.XML_240;

/**
 * Java class for creating a custom swing JFrame.
 * @author Jackson
 * @version 1.00
 */
public class MainFrame extends JFrame implements ActionListener
{
    SplashPanel splash;
    CreditsPanel credits;
    GamePanel game;
    InstructionsPanel instructions;
    SettingsPanel settings;
    Credits creditsList;
    int HEIGHT = 600, WIDTH = 800;
    /**
    * Constructor for class
    * @author Jackson
    * @version 1.00
    */
    public MainFrame ()
    {
        super ("Game");
        String size = getSavedSize();
        switch(size)
        {
            case "800 x 600":
                this.HEIGHT = 600;
                this.WIDTH = 800;
                break;
            case "1000 x 800":
                this.HEIGHT = 800;
                this.WIDTH = 1000;
                break;
            case "1200 x 1000":
                this.HEIGHT = 1000;
                this.WIDTH = 1200;
                break;
        }
        creditsList = new Credits();
        game = new GamePanel(WIDTH, HEIGHT);
        instructions = new InstructionsPanel(WIDTH, HEIGHT);
        settings = new SettingsPanel(WIDTH, HEIGHT);
        credits = new CreditsPanel(creditsList, HEIGHT, WIDTH);
        splash = new SplashPanel(HEIGHT, WIDTH);
        splash.creditsButton.addActionListener(this);
        splash.startGame.addActionListener(this);
        splash.instructionsButton.addActionListener(this);
        splash.settingsButton.addActionListener(this);
        game.back.addActionListener(this);
        instructions.back.addActionListener(this);
        settings.back.addActionListener(this);
        getContentPane().add(splash,"Center");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        refreshSize();
        setVisible(true);
    }
    
    /**
     * Returns the currently set resolution by reading it from the settings XML file.
     * @return size
     */
    public String getSavedSize()
    {
        XML_240 x2 = new XML_240();
        x2.openReaderXML("Options.xml");
        Setting res = (Setting)x2.ReadObject();
        x2.closeReaderXML();
        String size = res.getSettingValue();
        return size;
    }
    /**
     * Changes the size of the window to the current resolution.
     * Also updates the width and height in all of the panels.
     * The panel width and heights are used for positioning of components.
     */
    public void refreshSize()
    {
        String size = settings.options.resolution.getSettingValue();
        switch(size)
        {
            case "800 x 600":
                this.setSize (new Dimension(800, 600));
                WIDTH = 800;
                HEIGHT = 600;
                //settings panel
                settings.width = 800;
                settings.height = 600;
                //splash panel
                splash.WIDTH = 800;
                splash.HEIGHT = 600;
                //credits panel
                credits.width = 600;
                credits.height = 550;
                //game panel
                game.width = 800;
                game.height = 600;
                //instructions panel
                instructions.width = 800;
                instructions.height = 600;
                break;
            case "1000 x 800":
                WIDTH = 1000;
                HEIGHT = 800;
                //settings panel
                settings.width = 1000;
                settings.height = 800;
                //splash panel
                splash.WIDTH = 1000;
                splash.HEIGHT = 800;
                //credits panel
                credits.width = 800;
                credits.height = 750;
                //game panel
                game.width = 1000;
                game.height = 800;
                //instructions panel
                instructions.width = 1000;
                instructions.height = 800;
                this.setSize (new Dimension(1000, 800));
                break;
            case "1200 x 1000":
                WIDTH = 1200;
                HEIGHT = 1000;
                //settings panel
                settings.width = 1200;
                settings.height = 1000;
                //splash panel
                splash.WIDTH = 1200;
                splash.HEIGHT = 1000;
                //credits panel
                credits.width = 1000;
                credits.height = 950;
                //game panel
                game.width = 1200;
                game.height = 1000;
                //instructions panel
                instructions.width = 1200;
                instructions.height = 1000;
                this.setSize (new Dimension(1200, 1000));
                break;
        }
        this.setLocationRelativeTo(null);
    }
    /**
     * ActionPerformed listener for the class, currently removes current panel and adds credits panel upon click of a button
     * @param e ActionEvent for the listener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == splash.creditsButton) 
        { 
            credits.resetBounds();
            credits = new CreditsPanel(new Credits(), HEIGHT, WIDTH);
            credits.back.addActionListener(this);
            replacePanel(splash, credits);
        }
        if(obj == splash.startGame)
        {
            game.loadSettings();
            game.resetBounds();
            replacePanel(splash,game);
        }
        if(obj == splash.instructionsButton)
        {
            instructions.resetBounds();
            replacePanel(splash,instructions);
        }
        if(obj == splash.settingsButton)
        {
            settings.resetBounds();
            replacePanel(splash,settings);
        }
        if(obj == game.back)
        {
            splash.resetBounds();
            replacePanel(game,splash);
        }
        if(obj == credits.back)
        {
            splash.resetBounds();
            replacePanel(credits,splash);
        }
        if(obj == instructions.back)
        {
            splash.resetBounds();
            replacePanel(instructions,splash);
        }
        if(obj == settings.back)
        {
            refreshSize();
            splash.resetBounds();
            replacePanel(settings,splash);
        }
    }
    /**
     * Replaces the current panel with p2
     * @param p1 panel to be removed
     * @param p2 panel to be added
     */
    public void replacePanel(JPanel p1, JPanel p2)
    {
            this.remove(p1);
            this.add(p2);
            this.revalidate();
            this.repaint();
    }
}
