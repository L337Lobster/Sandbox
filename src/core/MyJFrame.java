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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Java class for creating a custom swing JFrame.
 * @author Jackson
 * @version 1.00
 */
public class MyJFrame extends JFrame implements ActionListener
{
    MyJPanel mjp;
    CreditsPanel mcp;
    public MyJFrame ()
    {
        super ("Game");

        Credits credits = new Credits();
        mjp = new MyJPanel();
        mcp = new CreditsPanel(credits);
        mjp.rollCredits = new JButton("Roll Credits");
        mjp.add(mjp.rollCredits);
        mjp.rollCredits.addActionListener(this);
        getContentPane().add(mjp,"Center");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (640, 480);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == mjp.rollCredits) 
        { 
            this.remove(mjp);
            this.add(mcp);
            this.revalidate();
            this.repaint();
        }
    }
}
