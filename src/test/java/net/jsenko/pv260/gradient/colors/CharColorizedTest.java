package net.jsenko.pv260.gradient.colors;

import org.junit.Test;

import static net.jsenko.pv260.gradient.colors.CharColorsTest.COLORS;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static net.jsenko.pv260.gradient.gradient.RadialGradientTest.GRADIENT;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class CharColorizedTest {

    private static final CharColorized CHAR_COLORIZED =
            new CharColorized(GRADIENT, COLORS);


    @Test(expected = NullPointerException.class)
    public void itShouldFailOnNullGrid() {
        new CharColorized(null, COLORS);
    }


    @Test(expected = NullPointerException.class)
    public void itShouldFailOnNullColors() {
        new CharColorized(GRADIENT, null);
    }


    @Test
    public void itShouldReturnCorrectChar() {
        assertEquals((Character) '0', CHAR_COLORIZED.get(ZERO));
        assertEquals((Character) '9', CHAR_COLORIZED.get(point(0, 10)));
        assertEquals((Character) '9', CHAR_COLORIZED.get(point(10, 10)));
        assertEquals((Character) '7', CHAR_COLORIZED.get(point(3, 7)));
    }
}
