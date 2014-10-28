/*
Changelog
=====================

*/

package settings;

import core.*;
import java.awt.*;
import javax.swing.*;

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
    public JButton label;
    public SettingsPanel()
    {
        super();
        setBackground(Color.gray);
        label = new JButton("settings");
        add(label);
    }


	
}
