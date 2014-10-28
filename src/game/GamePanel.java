/*
Changelog
=====================

*/

package game;

import core.*;
import java.awt.*;
import javax.swing.*;

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
    public JButton label;
    public GamePanel()
    {
        super();
        setBackground(Color.gray);
        label = new JButton("game");
        add(label);
    }


	
}
