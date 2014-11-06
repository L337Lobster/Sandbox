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
    public JButton back;
    public int width, height;
    /**
     * Constructor for the Instructions panel
     * @param width Width of the parent JFrame
     * @param height Height of the parent JFrame
     */
    public InstructionsPanel(int width, int height)
    {
        super();
        setBackground(Color.gray);
        back = new JButton("instructions");
        add(back);
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        
    }


	
}
