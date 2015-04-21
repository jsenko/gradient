package net.jsenko.pv260.gradient.colors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class CharColorsTest {

    public static final Colors COLORS = new CharColors("0123456789");

    public static final String COLOR_STRING;

    static {
        String colors = ".";
        for (int i = 0; i < 10; i++)
            colors += "0123456789";
        COLOR_STRING = colors;
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailOnOneColor() {
        new CharColors(".");
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailTooManyColors() {


        assertEquals(101, COLOR_STRING.length());
        new CharColors(COLOR_STRING);
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailForToLowLightness() {
        COLORS.color(-0.1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailForToHighLightness() {
        COLORS.color(1.1);
    }


    @Test
    public void itShouldReturnCorrectChar() {
        assertEquals('0', COLORS.color(0));
        assertEquals('9', COLORS.color(1));
        assertEquals('5', COLORS.color(0.5));
    }
}
