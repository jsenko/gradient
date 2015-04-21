package net.jsenko.pv260.gradient.gradient;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class LinearGradientTest {

    private static final LinearGradient GRADIENT
            = new LinearGradient(point(2, 2), ZERO);

    private static final double DELTA = 0.000001;


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailOnSamePoints() {
        new LinearGradient(ZERO, ZERO);
    }


    @Test
    public void itShouldReturnExpectedCellValues() {
        assertEquals(1, GRADIENT.get(ZERO), DELTA);
        assertEquals(0, GRADIENT.get(point(2, 2)), DELTA);
        assertEquals(0, GRADIENT.get(point(0, 4)), DELTA);
        assertEquals(0.5, GRADIENT.get(point(1, 1)), DELTA);
    }
}
