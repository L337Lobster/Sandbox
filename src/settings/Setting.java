/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

/**
 *
 * @author Jack
 */
public class Setting {
    
    private String settingName;
    private String settingValue;
    /**
     * Empty constructor due to XML preparation
     */
    public Setting()
    {
        
    }
    /**
     * Returns the name of the setting
     * @return settingName
     */
    public String getSettingName()
    {
        return settingName;
    }
    /**
     * Returns the value of the setting
     * @return settingValue
     */
    public String getSettingValue()
    {
        return settingValue;
    }
    /**
     * Sets the name of the setting
     * @param name 
     */
    public void setSettingName(String name)
    {
        settingName = name;
    }
    /**
     * Sets the value of the setting
     * @param value 
     */
    public void setSettingValue(String value)
    {
        settingValue = value;
    }
    
}