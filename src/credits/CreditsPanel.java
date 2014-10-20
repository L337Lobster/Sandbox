/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Jack
 */
public class CreditsPanel extends JPanel implements ActionListener{
    
    Credits credits = new Credits();
    Timer fadeTimer;
    ArrayList<JLabel> current;
    JButton fade;
    int roll = 0;
    ArrayList<Integer> in = new ArrayList();
    public CreditsPanel(Credits credits)
    {
        super();
        this.credits = credits;
        current = new ArrayList();
        setLayout(null);
        setBackground(Color.black);
        
        credits.compileCredits();
        fadeTimer = new Timer(10, this);
        for(int i = 0; i < credits.compiledCredits.size(); i++)
        {
            current.add(new JLabel("<html><center>"+credits.compiledCredits.get(i)+"</center></html>", JLabel.CENTER));
        }
        System.out.println(current.size());
        for(int i = 0; i < current.size(); i++)
        {
            in.add(500);
            current.get(i).setForeground(Color.white);
            current.get(i).setFont(current.get(i).getFont().deriveFont(45.0f));
            add(current.get(i));
            current.get(i).setBounds(new Rectangle(100, in.get(i), 400, 100));
        }
        
        
        fadeTimer.start();
        for(int i =0; i < credits.compiledCredits.size(); i++)
        {
            System.out.println(credits.compiledCredits.get(i));
        }
        roll = current.size();
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==fadeTimer)
        {
            if(in.get(current.size()-1) > -200)
            {
                for(int i = 0; i <= current.size() - roll; i++)
                {
                    current.get(i).setBounds(new Rectangle(100, in.get(i), 400, 100));
                    if(in.get(i) > -200)
                    {
                        in.set(i, in.get(i) - 1);
                    }
                }
                if(in.get(current.size()-roll) < 400)
                {
                    if(roll != 1)
                    {
                        roll--;
                    }
                }
            }
            else{
                this.setBackground(Color.red);
            }
        
        }
    }
    
}
