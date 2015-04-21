package net.jsenko.pv260.gradient.state;

import org.junit.Test;

import net.jsenko.pv260.gradient.cli.Handler;
import static net.jsenko.pv260.gradient.cli.States.COLORS;
import static net.jsenko.pv260.gradient.cli.States.GRADIENT;
import static net.jsenko.pv260.gradient.colors.CharColorsTest.COLOR_STRING;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class ColorStateTest {

    private Handler handler = new Handler();

    @Test
    public void itShouldReturnCorrectState() {
        // bad
        assertEquals(COLORS, COLORS.run(handler, ""));
        assertEquals(COLORS, COLORS.run(handler, "."));
        assertEquals(COLORS, COLORS.run(handler, COLOR_STRING));

        // good
        assertEquals(GRADIENT, COLORS.run(handler, " . "));
        assertEquals(GRADIENT, COLORS.run(handler, "(.)(.)"));
        assertEquals(GRADIENT, COLORS.run(handler, " .:#"));
    }
}
