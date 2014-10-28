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
import settings.SettingsPanel;

/**
 * Java class for creating a custom swing JFrame.
 * @author Jackson
 * @version 1.00
 */
public class MainFrame extends JFrame implements ActionListener
{
    SplashPanel splash;
    CreditsPanel mcp;
    GamePanel game;
    InstructionsPanel instructions;
    SettingsPanel settings;
    Credits credits;
    int HEIGHT = 600, WIDTH = 800;
    /**
    * Constructor for class
    * @author Jackson
    * @version 1.00
    */
    public MainFrame ()
    {
        super ("Game");
        credits = new Credits();
        game = new GamePanel();
        instructions = new InstructionsPanel();
        settings = new SettingsPanel();
        mcp = new CreditsPanel(credits, HEIGHT, WIDTH);
        splash = new SplashPanel(HEIGHT, WIDTH);
        splash.creditsButton.addActionListener(this);
        splash.startGame.addActionListener(this);
        splash.instructionsButton.addActionListener(this);
        splash.settingsButton.addActionListener(this);
        game.label.addActionListener(this);
        instructions.label.addActionListener(this);
        settings.label.addActionListener(this);
        mcp.label.addActionListener(this);
        getContentPane().add(splash,"Center");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (new Dimension(WIDTH, HEIGHT));
        setVisible(true);
    }
    /**
     * ActionPerformed listener for the class, currently removes current panel and adds credits panel upon click of a button
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == splash.creditsButton) 
        { 
            mcp = new CreditsPanel(credits, HEIGHT, WIDTH);
            replacePanel(splash, mcp);
        }
        if(obj == splash.startGame)
        {
            replacePanel(splash,game);
        }
        if(obj == splash.instructionsButton)
        {
            replacePanel(splash,instructions);
        }
        if(obj == splash.settingsButton)
        {
            replacePanel(splash,settings);
        }
        if(obj == game.label)
        {
            replacePanel(game,splash);
        }
        if(obj == mcp.label)
        {
            replacePanel(mcp,splash);
        }
        if(obj == instructions.label)
        {
            replacePanel(instructions,splash);
        }
        if(obj == settings.label)
        {
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
