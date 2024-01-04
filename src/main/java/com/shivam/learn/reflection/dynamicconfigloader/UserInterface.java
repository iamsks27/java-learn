package com.shivam.learn.reflection.dynamicconfigloader;

import java.util.Arrays;

/**
 * @author sksingh created on 12/12/23
 */
public class UserInterface {

    private String titleColor;
    private int titleFontSize;
    private int footerFontSize;
    private String[] titleFonts;

    public String getTitleColor() {
        return titleColor;
    }

    public int getTitleFontSize() {
        return titleFontSize;
    }

    public int getFooterFontSize() {
        return footerFontSize;
    }

    @Override
    public String toString() {
        return "UserInterface{" +
                "titleColor='" + titleColor + '\'' +
                ", titleFontSize=" + titleFontSize +
                ", footerFontSize=" + footerFontSize +
                ", titleFonts=" + Arrays.toString(titleFonts) +
                '}';
    }
}
