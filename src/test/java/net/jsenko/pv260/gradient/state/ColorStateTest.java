package net.jsenko.pv260.gradient.state;

import org.junit.Test;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.States;
import net.jsenko.pv260.gradient.colors.CharColors;
import net.jsenko.pv260.gradient.colors.Colors;
import static net.jsenko.pv260.gradient.cli.States.COLORS;
import static net.jsenko.pv260.gradient.cli.States.DISPLAY_SIZE;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class ColorStateTest {

    private Handler handler = new Handler();

    @Test
    public void itShouldReturnCorrectState() {
        assertEquals(COLORS, DISPLAY_SIZE.run(handler, "10 10"));
    }
}
