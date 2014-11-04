/*
Changelog
=====================

*/

package settings;

import core.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import util.XML_240;

/**
 * Java class for creating the a custom swing JPanel.
 * @author Jackson
 * @version 1.00
 */
public class SettingsPanel extends JPanel
{

    /**
     * Constructor for the class
     * @since version 1.00
     */
    public JButton back, save;
    JComboBox resolutionV, difficultyV, musicV;
    XML_240 x2;
    public Options options;
    JLabel difficultyL, resolutionL, musicL;
    public int width, height;
    public SettingsPanel(int width, int height)
    {
        super();
        this.width = width;
        this.height = height;
        x2 = new XML_240();
        //String arrays for the different option comboboxes
        String[] difficulties = {"Easy", "Medium", "Hard"};
        String[] resolutions = { "800 x 600", "1000 x 800", "1200 x 1000"};
        String[] musics = { "On", "Off"};
        //change layout
        setLayout(null);
        
        setBackground(Color.gray);
        //back button, takes you to main menu
        back = new JButton("Main Menu");
        add(back);
        back.setBounds(new Rectangle(200,300,200,50));
        //initializes the options
        options = new Options();
        //creates a label for both options
        resolutionL = new JLabel(options.resolution.getSettingName() + ":");
        difficultyL = new JLabel(options.difficulty.getSettingName() + ":");
        musicL = new JLabel(options.music.getSettingName() + ":");
        //add option labels
        add(resolutionL);
        add(difficultyL);
        add(musicL);
        //create comboboxes for settings and set the selected item to the current setting
        difficultyV = new JComboBox(difficulties);
        resolutionV = new JComboBox(resolutions);
        musicV = new JComboBox(musics);
        //add combo boxes
        add(difficultyV);
        add(resolutionV);
        add(musicV);
        
        //save settings button
        save = new JButton("Save Settings");
        SaveListener saveListener = new SaveListener();
        save.addActionListener(saveListener);
        add(save);
    }
    public void resetBounds()
    {
        difficultyV.setBounds(new Rectangle(((width/4)-50), ((height/2)-100),100,25));
        difficultyL.setBounds(new Rectangle(((width/4)-50), ((height/2)-125),100,25));
        resolutionV.setBounds(new Rectangle(((width/4*2)-50), ((height/2)-100),100,25));
        resolutionL.setBounds(new Rectangle(((width/4*2)-50), ((height/2)-125),100,25));
        musicV.setBounds(new Rectangle((width/4*3)-50, ((height/2)-100),100,25));
        musicL.setBounds(new Rectangle((width/4*3)-50, ((height/2)-125),100,25));
        back.setBounds(new Rectangle((width/3)-100,height/2,200,50));
        save.setBounds(new Rectangle((width/3*2)-100, height/2, 200,50));
        switch(options.resolution.getSettingValue())
        {
            case "800 x 600":
                resolutionV.setSelectedIndex(0);
                break;
            case "1000 x 800":
                resolutionV.setSelectedIndex(1);
                break;
            case "1200 x 1000":
                resolutionV.setSelectedIndex(2);
                break;
        }
        switch(options.difficulty.getSettingValue())
        {
            case "Easy":
                difficultyV.setSelectedIndex(0);
                break;
            case "Medium":
                difficultyV.setSelectedIndex(1);
                break;
            case "Hard":
                difficultyV.setSelectedIndex(2);
                break;
            default:
                JOptionPane.showMessageDialog(SettingsPanel.this,"Difficulty: " + options.difficulty.getSettingValue());
                break;
                
        }
        switch(options.music.getSettingValue())
        {
            case "On":
                musicV.setSelectedIndex(0);
                break;
            case "Off":
                musicV.setSelectedIndex(1);
                break;
        }
    }
    public class SaveListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String resolution, difficulty, music;
            difficulty = (String)difficultyV.getSelectedItem();
            resolution = (String)resolutionV.getSelectedItem();
            music = (String)musicV.getSelectedItem();
            options.difficulty.setSettingValue(difficulty);
            options.resolution.setSettingValue(resolution);
            options.music.setSettingValue(music);
            x2.openWriterXML("Options.xml");
            x2.writeObject(options.resolution);
            x2.writeObject(options.difficulty);
            x2.writeObject(options.music);
            x2.closeWriterXML();
            JOptionPane.showMessageDialog(SettingsPanel.this,"Save Successful!");
            
        }
        
    }

	
}
