/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

/**
 * Class that creates Settings Objects.
 * Individual Setting Objects hold the values for specific options.
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
     * @param name String value for the name of the setting
     */
    public void setSettingName(String name)
    {
        settingName = name;
    }
    /**
     * Sets the value of the setting
     * @param value String value for the value of the setting
     */
    public void setSettingValue(String value)
    {
        settingValue = value;
    }
    
}
