/*
Changelog
=====================

*/

package game;

import core.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import settings.Setting;
import util.XML_240;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class GamePanel extends JPanel implements ActionListener
{
    /**
     * Constructor for the class
     * @since version 1.00
     */
    public JButton back;
    public int width, height;
    Setting music, difficulty, resolution;
    JLabel difficultyL;
    Music psuMedly;
    public Timer tim;
    Rectangle player;
    int delay = 10, difficultyInt;
    public int x,y;
    ArrayList<Integer> blockerPos;
    ArrayList<Rectangle> blockerRect;
    boolean movingUp;
    
    
    public GamePanel(int width, int height)
    
    {
        super();
        try {
            psuMedly = new Music("fightOn");
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.width = width;
        this.height = height;
        player = new Rectangle();
        x = 50;
        y = height/2;
        blockerPos = new ArrayList();
        for(int i = 0; i < 10; i++)
        {
            blockerPos.add(width);
        }
        setBackground(Color.white);
        setLayout(null);
        back = new JButton("Main Menu");
        add(back);
        loadSettings();
        difficultyL = new JLabel("Difficulty: " + difficulty.getSettingValue());
        difficultyL.setFont(difficultyL.getFont().deriveFont(20.0f));
        add(difficultyL);
        tim = new Timer(delay, this);
        movingUp=false;
        setDifficulty();
        
    }
    public final void setDifficulty()
    {
        switch(difficulty.getSettingValue())
        {
            case "Easy":
                difficultyInt = 1;
                break;
            case "Medium":
                difficultyInt = 3;
                break;
            case "Hard":
                difficultyInt = 10;
                break;
        }
    }
    public Music getMusic()
    {
        return this.psuMedly;
    }
    /**
     * Repositions the panel's components after a resize.
     */
    public void resetBounds()
    {
        back.setBounds(new Rectangle(width-207,0,200, 50));
        difficultyL.setBounds(new Rectangle(0, 0, 200, 25));
        difficultyL.setText("Difficulty: " + difficulty.getSettingValue());
    }
    /**
     * Read the resolution, difficulty, and music settings from file.
     */
    public final void loadSettings()
    {
        XML_240 x2 = new XML_240();
        x2.openReaderXML("Options.xml");
        resolution = (Setting)x2.ReadObject();
        difficulty = (Setting)x2.ReadObject();
        music = (Setting)x2.ReadObject();
        x2.closeReaderXML();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == tim)
        {
            player.setBounds(new Rectangle(x,y,50,50));
            int x1=width, y1=height-125, x2=50, y2=100;
            for(int i = 0; i < blockers.size(); i++)
            {
                
            }
            blocker.setBounds(new Rectangle(x1, y1, x2, y2));
            if (y>=height-80) 
            {
                movingUp = true;                
            }
            else if (y<height/2)
            {
                movingUp = false;
            }
            if(movingUp)
            {
                y-= difficultyInt;
                this.repaint();
            }
            if(!movingUp)
            {
                y+=difficultyInt;
                this.repaint();
            }
            for(int i = 0; i < blockerPos.size(); i++)
            {
                if(blockerPos.get(i) < -60)
                {
                    blockerPos.set(i, width);
                }
                if(blockerPos.get(i) > -65)
                {
                    blockerPos.set(i, blockerPos.get(i)-5);;
                }
            }
            if(player.intersects(blocker))
            {
                JOptionPane.showMessageDialog(GamePanel.this,"You hit him, how dare you!");
                back.doClick();
                tim.stop();
            }
        }
        
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(CustomColor.PSU_DARK.toColor());
        g.fillOval(x, y, 50, 50);
        int x1=block1, y1=height-125, x2=50, y2=100;
        g.setColor(CustomColor.OHIO_RED.toColor());
        g.fillRect(x1, y1, x2, y2);
    }
	
}
