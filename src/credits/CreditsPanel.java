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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Java class for creating the a custom swing JPanel for the credits.
 * @author Jackson
 * @version 1.00
 */
public class CreditsPanel extends JPanel implements ActionListener{
    
    Credits credits = new Credits();
    Timer fadeTimer;
    JButton delteThis;
    ArrayList<JLabel> current;
    int roll = 0;
    ArrayList<Integer> in = new ArrayList(); //array list for the y value of each rectangle that the JLabels are in
    
    /**
     * Creates and displays the credits.
     * @param credits 
     */
    public CreditsPanel(Credits credits)
    {
        super();
        this.credits = credits;
        current = new ArrayList();
        setLayout(null);
        setBackground(Color.black);
        
        credits.compileCredits();
        fadeTimer = new Timer(10, this);
        for(int i = 0; i < credits.compiledCredits.size(); i++)
        {
            current.add(new JLabel("<html><center>"+credits.compiledCredits.get(i)+"</center></html>", JLabel.CENTER));
        }
        for(int i = 0; i < current.size(); i++)
        {
            in.add(500);
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
            current.get(i).setBounds(new Rectangle(100, in.get(i), 400, 100));
        }
        
        
        fadeTimer.start();
        roll = current.size();
        
        
        
    }
    /**
     * Action listener for the panel, currently only used for the timer
     * @param e 
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
                    current.get(i).setBounds(new Rectangle(100, in.get(i), 400, 100));
                    if(in.get(i) > -200)
                    {
                        in.set(i, in.get(i) - 1);
                    }
                }
                if(in.get(current.size()-roll) < 400)
                {
                    if(roll != 1)
                    {
                        roll--;
                    }
                }
            }
            else{
                this.setBackground(Color.red);
            }
        
        }
    }
    
}
