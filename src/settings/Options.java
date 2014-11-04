/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import util.XML_240;

/**
 *
 * @author Jack
 */
public class Options {
    
    public Setting resolution, difficulty, music;
    XML_240 x2;
    Options()
    {
        resolution = new Setting();
        difficulty = new Setting();
        music = new Setting();
        x2 = new XML_240();
        
        x2.openReaderXML("Options.xml");
        resolution = (Setting)x2.ReadObject();
        difficulty =  (Setting)x2.ReadObject();
        music =  (Setting)x2.ReadObject();
        x2.closeReaderXML();
        
    }
    
}
