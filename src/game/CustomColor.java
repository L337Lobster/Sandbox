/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Color;

/**
 *
 * @author jph5321
 */
public enum CustomColor {
    
    PSU_DARK(0, 23, 105),
    OHIO_RED(187,0,0),
    MICHIGAN_YELLOW(255,204,51),
    NORTHWESTERN_PURPLE(82,0,99);
    
    public int r, g, b;
    
    private CustomColor(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Color toColor()
    {
        return new Color(r, g, b);
    }
}
