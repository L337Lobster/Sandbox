/*
Changelog
=====================
19 October 2014
    -1600 hours
        *initial creation
20 October 2014
    -0430
        *added different formatting for names, contributions, and "Credits"
*/
package credits;

import game.Music;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
/**
 * Java class for creating the a custom swing JPanel for the credits.
 * @author Jackson
 * @version 1.00
 */
public class CreditsPanel extends JPanel implements ActionListener{
    
    Credits credits = new Credits();
    Timer fadeTimer;
    ArrayList<JLabel> current;
    Music almaMater;
    int roll = 0;
    public int height = 0, width = 0;
    ArrayList<Integer> in = new ArrayList(); //array list for the y value of each rectangle that the JLabels are in
    public JButton back;
    
    /**
     * Creates and displays the credits.
     * @param credits a variable of type Credits
     * @param height Height of the parent JFrame
     * @param width Width of the parent JFrame
     */
    public CreditsPanel(Credits credits, int height, int width) throws UnsupportedAudioFileException, LineUnavailableException
    {        
        super();
        try {
            almaMater = new Music("almaMater");
        } catch (IOException ex) {
            Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.credits = credits;
        this.height = height;
        current = new ArrayList();
        this.width = width;
        setLayout(null);
        setBackground(Color.black);
        back = new JButton("Main Menu");
        add(back);
        credits.compileCredits();
        fadeTimer = new Timer(5, this);
        for(int i = 0; i < credits.compiledCredits.size(); i++)
        {
            current.add(new JLabel("<html><center>"+credits.compiledCredits.get(i)+"</center></html>", JLabel.CENTER));
        }
        for(int i = 0; i < current.size(); i++)
        {
            in.add(height);
            current.get(i).setForeground(Color.white);
            if(credits.compiledCredits.get(i).equalsIgnoreCase("Credits"))
            {
                current.get(i).setFont(current.get(i).getFont().deriveFont(55.0f));
                current.get(i).setForeground(Color.white);
            }
            else if(credits.compiledCredits.get(i).equalsIgnoreCase("Jackson Hofmann") || credits.compiledCredits.get(i).equalsIgnoreCase("Michelle Kracaw") || credits.compiledCredits.get(i).equalsIgnoreCase("Nicholas Stegers"))
            {
                current.get(i).setFont(current.get(i).getFont().deriveFont(45.0f));
                current.get(i).setForeground(Color.cyan);
            }
            else
            {
                current.get(i).setFont(current.get(i).getFont().deriveFont(35.0f));
                current.get(i).setForeground(Color.white);
            }
            add(current.get(i));
            current.get(i).setBounds(new Rectangle(0, in.get(i), width, 100));
        }
        
        
        fadeTimer.start();
        roll = current.size();
        
        
        
    }
    public Music getMusic()
    {
        return this.almaMater;
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        for(int i = 0; i < current.size(); i++)
        {
            in.set(i, height);
            current.get(i).setBounds(new Rectangle(0, in.get(i), width, 100));
        }
    }
    /**
     * Action listener for the panel, currently only used for the timer
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==fadeTimer)
        {
            if(in.get(current.size()-1) > -200)
            {
                for(int i = 0; i <= current.size() - roll; i++)
                {
                    current.get(i).setBounds(new Rectangle(0, in.get(i), width, 100));
                    if(in.get(i) > -200)
                    {
                        in.set(i, in.get(i) - 1);
                    }
                }
                if(in.get(current.size()-roll) < height-100)
                {
                    if(roll != 1)
                    {
                        roll--;
                    }
                }
            }
            else{
                back.setBounds(new Rectangle((width/2)-100, ((height/2)-50), 200, 50));
            }
        
        }
    }
    
}
