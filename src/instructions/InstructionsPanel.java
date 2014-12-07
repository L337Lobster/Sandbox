/*
Changelog
=====================

*/

package instructions;

import core.*;
import game.CustomColor;
import java.awt.*;
import javax.swing.*;
import settings.Setting;
import util.XML_240;

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
    public Setting resolution;
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
        back = new JButton("Main Menu");
        add(back);
        back.setBounds(new Rectangle(width-100, 0, 100,50));
        loadRes();
        this.width = width;
        this.height = height;
        this.setBackground(Color.WHITE);
        directions = new JLabel ("<html><center>The object of the game is to keep the Penn State player from running into any of the on-coming players. "
                + "Use any key to hold the Penn State player in place." +
                "You will only have 2 seconds on the Penalty Timer before the player will begin to move again.</center></html>"
                );
        directions.setFont(directions.getFont().deriveFont(24.0f));
        directions.setForeground(CustomColor.PSU_DARK.toColor());
        add (directions);
        int x = (this.width - (this.width/2))/2;
        int y = (this.height - (this.height/2))/2;
        directions.setBounds(new Rectangle(x,y,this.width/2,this.height/2));
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        int x = (width - (this.width/2))/2;
        int y = (this.height - (this.height/2))/2;
        directions.setBounds(new Rectangle(x,y,this.width/2,this.height/2));
    }
    public void loadRes()
    {
        XML_240 x2 = new XML_240();
        x2.openReaderXML("Options.xml");
        resolution = (Setting)x2.ReadObject();
        x2.ReadObject();
        x2.ReadObject();
        x2.closeReaderXML();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image bg_big = Toolkit.getDefaultToolkit().getImage("images/menuBG_big.jpg");
        Image bg_med = Toolkit.getDefaultToolkit().getImage("images/menuBG_med.jpg");
        Image bg_sm = Toolkit.getDefaultToolkit().getImage("images/menuBG_sm.jpg");
        switch(resolution.getSettingValue())
        {
            case "1200 x 1000":
                g.drawImage(bg_big, 0, 0, this);
                break;
            case "1000 x 800":
                g.drawImage(bg_med, 0, 0, this);
                break;
            case "800 x 600":
                g.drawImage(bg_sm, 0, 0, this);
                break;
        }
        int y = (this.height - (this.height/2))/2;
        int x = (width - (this.width/2))/2;
        g.setColor(Color.WHITE);
        g.fillRect(x,y,this.width/2,this.height/2);
        
    }


	
}
