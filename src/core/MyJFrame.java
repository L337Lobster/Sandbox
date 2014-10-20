/*
Changelog
=====================
19 October 2014
    -1600 hours
        *initial creation
*/

package core;

import credits.Credits;
import credits.CreditsPanel;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Java class for creating a custom swing JFrame.
 * @author Jackson
 * @version 1.00
 */
public class MyJFrame extends JFrame
{
    public MyJFrame ()
    {
        super ("Game");

        Credits credits = new Credits();
        MyJPanel mjp = new MyJPanel();
        CreditsPanel mcp = new CreditsPanel(credits);

        getContentPane().add(mjp,"Center");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (640, 480);
        setVisible(true);
    }

}
