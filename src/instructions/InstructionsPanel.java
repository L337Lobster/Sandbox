/*
Changelog
=====================

*/

package instructions;

import core.*;
import java.awt.*;
import javax.swing.*;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class InstructionsPanel extends JPanel
{

    /**
     * Constructor for the class
     * @since version 1.00
     */
    public JButton label;
    public int width, height;
    public InstructionsPanel()
    {
        super();
        setBackground(Color.gray);
        label = new JButton("instructions");
        add(label);
    }
    public void resetBounds()
    {
        
    }


	
}
