/*
Changelog
=====================

*/

package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    JLabel difficultyL, scoreL;
    public JLabel penaltyL;
    Music psuMedly;
    public Timer tim, penaltyT;
    Rectangle player;
    int delay = 10, difficultyInt, blockerDifficulty, score;
    final int BLOCK_OFFSET = 500;
    public int x,y, penalty;
    int x1, y1, x2=50, y2=100;
    ArrayList<Integer> blockerPos;
    ArrayList<Rectangle> blockerRect;
    ArrayList<Boolean> lastBlocker;
    Color currentColor;
    public boolean playerMoving = true, penaltyHit = false;
    boolean movingUp;
    
    /**
     * Constructor for the Game Panel.
     * Creates the initial panel components.
     * @param width width of the panel,
     * @param height height of the panel.
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public GamePanel(int width, int height) throws UnsupportedAudioFileException, LineUnavailableException
    
    {
        super();
        try {
            psuMedly = new Music("fightOn");
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.width = width;
        this.height = height;
        currentColor = CustomColor.OHIO_RED.toColor();
        score = 0;
        player = new Rectangle();
        x = 50;
        y = this.height-400;
        x1 = this.width;
        y1 = this.height-125;
        blockerPos = new ArrayList();
        int add = width;
        blockerRect = new ArrayList();
        lastBlocker = new ArrayList();
        for(int i = 0; i < 4; i++)
        {
            blockerPos.add(add);
            add+=BLOCK_OFFSET;
            blockerRect.add(new Rectangle());
            if(i < 3)
            {
                lastBlocker.add(false);
            }
            else
            {
                lastBlocker.add(true);
            }
        }
        setBackground(Color.white);
        setLayout(null);
        back = new JButton("Main Menu");
        add(back);
        loadSettings();
        scoreL = new JLabel("Score: " + score);
        scoreL.setFont(scoreL.getFont().deriveFont(20.0f));
        difficultyL = new JLabel("Difficulty: " + difficulty.getSettingValue());
        difficultyL.setFont(difficultyL.getFont().deriveFont(20.0f));
        penalty = 10;
        penaltyL = new JLabel("Penalty Timer: " + penalty);
        penaltyL.setFont(penaltyL.getFont().deriveFont(20.0f));
        penaltyL.setForeground(CustomColor.PSU_DARK.toColor());
        scoreL.setForeground(CustomColor.PSU_DARK.toColor());
        add(difficultyL);
        add(scoreL);
        add(penaltyL);
        tim = new Timer(delay, this);
        penaltyT = new Timer(200, this);
        movingUp=false;
        setDifficulty();
        
    }

    /**
     * Sets the difficulty numbers based on the current difficulty setting.
     */
    public final void setDifficulty()
    {
        switch(difficulty.getSettingValue())
        {
            case "Easy":
                difficultyInt = 3;
                blockerDifficulty = 2;
                break;
            case "Medium":
                difficultyInt = 5;
                blockerDifficulty = 3;
                break;
            case "Hard":
                difficultyInt = 15;
                blockerDifficulty = 10;
                break;
        }
    }

    /**
     * Returns the music for this panel.
     * @return psuMedly
     */
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
        scoreL.setBounds(new Rectangle((width/2)-75, -15, 200,50));
        penaltyL.setBounds(new Rectangle((width/2)-75, 20, 200,50));
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

    /**
     * Resets the game back to the starting parameters.
     */
    public void resetGame()
    {
        penaltyHit = false;
        x = 50;
        penalty = 10;
        y = height/2;
        score = 0;
        playerMoving = true;
        scoreUpdate();
        int add = width;
        blockerPos.clear();
        blockerRect.clear();
        lastBlocker.clear();
        y1 = this.height-125;
        for(int i = 0; i < 4; i++)
        {
            blockerPos.add(add);
            add+=BLOCK_OFFSET;
            blockerRect.add(new Rectangle());
            if(i < 3)
            {
                lastBlocker.add(false);
            }
            else
            {
                lastBlocker.add(true);
            }
        }
    }
    void changeColor(int score)
    {
        if(score == 0)
        {
            currentColor = CustomColor.OHIO_RED.toColor();
        }
        if(score % 10 == 0)
        {
            currentColor = CustomColor.MICHIGAN_YELLOW.toColor();
        }
        if(score % 20 == 0)
        {
            currentColor = CustomColor.NORTHWESTERN_PURPLE.toColor();
        }
        if(score % 30 == 0)
        {
            currentColor = CustomColor.OHIO_RED.toColor();
        }
    }
    void scoreUpdate()
    {
        scoreL.setText("Score: " + score);
        changeColor(score);
        if(score != 0 && (score % 10) == 0)
            {
                difficultyInt+=2;
                blockerDifficulty+=3;
            }
    }

    /**
     * Action listener for the timers.
     * Penalty timer uses this to decrement the visual timer and change the text.
     * The main timer is uses this to move the player and blockers as well as detect collision.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == penaltyT)
        {
            penaltyHit = true;
            penalty--;
            penaltyL.setText("Penalty Timer: " + penalty);
        }
        if (obj == tim)
        {
            player.setBounds(new Rectangle(x,y,50,50));
            if(penalty <= 0)
            {
                penaltyT.stop();
                penalty = 10;
                score--;
                scoreUpdate();
                penaltyL.setText("Penalty Timer: " + penalty);
                playerMoving = true;
            }
            for(int i = 0; i < blockerRect.size(); i++)
            {
                blockerRect.set(i, new Rectangle(blockerPos.get(i), y1, x2, y2));
            }
            if (y>=height-80) 
            {
                movingUp = true;                
            }
            else if (y< (height/3))
            {
                movingUp = false;
            }
            if(movingUp && playerMoving)
            {
                y-= difficultyInt;
            }
            if(!movingUp && playerMoving)
            {
                y+=difficultyInt;
            }
            for(int i = 0; i < blockerPos.size(); i++)
            {
                if(blockerPos.get(i) < -60)
                {
                    score++;
                    scoreUpdate();
                    int j;
                    for(j = 0; j < lastBlocker.size(); j++)
                    {
                        if(lastBlocker.get(j))
                        {
                            lastBlocker.set(j, false);
                            if(j == lastBlocker.size()-1)
                            {
                                lastBlocker.set(0, true);
                            }
                            else
                            {
                                lastBlocker.set(j+1, true);
                            }
                            break;
                        }
                    }
                    blockerPos.set(i, blockerPos.get(j)+BLOCK_OFFSET);
                }
                if(blockerPos.get(i) > -65)
                {
                    blockerPos.set(i, blockerPos.get(i)-blockerDifficulty);;
                }
                if(player.intersects(blockerRect.get(i)))
                {
                    JOptionPane.showMessageDialog(GamePanel.this,"You hit him, how dare you!");
                    back.doClick();
                }
            }
            this.repaint();            
        }        
    }

    /**
     * Paints the background image, player, and blockers.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image bg_big = Toolkit.getDefaultToolkit().getImage("images/gmae_big.png");
        Image bg_med = Toolkit.getDefaultToolkit().getImage("images/game_med.png");
        Image bg_sm = Toolkit.getDefaultToolkit().getImage("images/game_sm.png");
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
        g.setColor(Color.white);
        g.fillRect((width/2)-75, 35, 175,25);
        g.fillRect((width/2)-75, 0, 100,25);
        Image playerHelmet = Toolkit.getDefaultToolkit().getImage("images/helmet.png");
        Image blockerImage = Toolkit.getDefaultToolkit().getImage("images/ohiostateplayer.png");
        g.setColor(CustomColor.PSU_DARK.toColor());
        g.drawImage(playerHelmet, x, y, this);
        //g.fillOval(x, y, 50, 50);
        g.setColor(currentColor);
        for(int i = 0; i < blockerPos.size();i++)
        {
            x1 = blockerPos.get(i);
            g.fillRect(x1, y1, x2, y2);
            g.drawImage(blockerImage, x1, y1, this);
        }
    }	
}
