package net.jsenko.pv260.gradient.state;

import org.junit.Test;

import net.jsenko.pv260.gradient.cli.Handler;
import static net.jsenko.pv260.gradient.cli.States.COLORS;
import static net.jsenko.pv260.gradient.cli.States.DISPLAY_SIZE;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class DisplaySizeStateTest {

    private Handler handler = new Handler();

    @Test
    public void itShouldReturnCorrectState() {
        // bad
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, ""));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "10"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "10 10 10"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "x 10"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "10 x"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "x x"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "-10 10"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "10 -10"));
        assertEquals(DISPLAY_SIZE, DISPLAY_SIZE.run(handler, "-10 -10"));

        // good
        assertEquals(COLORS, DISPLAY_SIZE.run(handler, "10 0"));
        assertEquals(COLORS, DISPLAY_SIZE.run(handler, "10 10"));
        assertEquals(COLORS, DISPLAY_SIZE.run(handler, "10     10    "));
    }
}
