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

import java.awt.*;
import javax.swing.*;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class SplashPanel extends JPanel
{

    JButton creditsButton, startGame, instructionsButton, settingsButton;
    int HEIGHT = 0, WIDTH = 0;
    /**
     * Constructor for the class
     * @since version 1.00
     */
    public SplashPanel(int height, int width)
    {
        super();
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
    }


	
}
