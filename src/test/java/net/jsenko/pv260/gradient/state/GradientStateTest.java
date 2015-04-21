package net.jsenko.pv260.gradient.state;

import org.junit.Test;

import net.jsenko.pv260.gradient.cli.Handler;
import static net.jsenko.pv260.gradient.cli.States.DONE;
import static net.jsenko.pv260.gradient.cli.States.GRADIENT;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class GradientStateTest {

    private Handler handler = new Handler();

    @Test
    public void itShouldReturnCorrectState() {
        handler.displaySize(0, 0);
        handler.colors(" .:#");

        // bad
        assertEquals(GRADIENT, GRADIENT.run(handler, "x"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "radial"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "radial x 0 1"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "radial 0 0 -1"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "radial 0 0 1 1"));

        assertEquals(GRADIENT, GRADIENT.run(handler, "linear"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "linear x 0 1 -1"));
        assertEquals(GRADIENT, GRADIENT.run(handler, "linear 0 1 0 1"));

        // good
        assertEquals(DONE, GRADIENT.run(handler, "radial 0 0 1"));
        assertEquals(DONE, GRADIENT.run(handler, "radial 0    0 0"));
        assertEquals(DONE, GRADIENT.run(handler, "radial    0 0   1"));
        assertEquals(DONE, GRADIENT.run(handler, "linear 0 0 -1 1"));
        assertEquals(DONE, GRADIENT.run(handler, "linear  0 0    -1    1"));
    }
}
