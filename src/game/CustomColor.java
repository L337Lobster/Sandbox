/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Color;

/**
 * Enumeration type for custom colors.
 * @author jph5321
 */
public enum CustomColor {
    
    /**
     * Psu navy blue color.
     */
    PSU_DARK(0, 23, 105),

    /**
     * Ohio red color.
     */
    OHIO_RED(187,0,0),

    /**
     * Michigan yellow color.
     */
    MICHIGAN_YELLOW(255,204,51),

    /**
     * Northwestern purple color.
     */
    NORTHWESTERN_PURPLE(82,0,99);
    
    public int r, g, b;
    
    private CustomColor(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    /**
     * Returns the colors as a Color object.
     * @return new Color(r,g,b)
     */
    public Color toColor()
    {
        return new Color(r, g, b);
    }
}
