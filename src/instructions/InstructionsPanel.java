/*
Changelog
=====================

*/

package instructions;

import core.*;
import game.CustomColor;
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
    public JLabel directions;
    /**
     * Constructor for the Instructions panel
     * @param width Width of the parent JFrame
     * @param height Height of the parent JFrame
     */
    public InstructionsPanel(int width, int height)
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
        back = new JButton("instructions");
        add(back);
        this.width = width;
        this.height = height;
        this.setBackground(Color.WHITE);
        directions = new JLabel ("<html><center>The object of the game is to keep the Penn State player from running into any of the on-coming players. "
                + "Use any key to hold the Penn State player in place." +
                "You will only have 10 seconds on the Penalty Timer before the player will begin to move again.</center></html>"
                );
        directions.setFont(directions.getFont().deriveFont(24.0f));
        directions.setForeground(CustomColor.PSU_DARK.toColor());
        add (directions);
        int x = (width - (this.width/2))/2;
        directions.setBounds(new Rectangle(x,0,this.width/2,this.height));
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        
    }


	
}
