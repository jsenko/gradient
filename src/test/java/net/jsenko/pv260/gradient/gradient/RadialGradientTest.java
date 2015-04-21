package net.jsenko.pv260.gradient.gradient;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class RadialGradientTest {

    public static final RadialGradient GRADIENT
            = new RadialGradient(ZERO, 10);

    private static final double DELTA = 0.000001;


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailNegativeRadius() {
        new RadialGradient(ZERO, -1);
    }


    @Test
    public void itShouldReturnExpectedCellValues() {
        assertEquals(0, GRADIENT.get(ZERO), DELTA);
        assertEquals(1, GRADIENT.get(point(0, 10)), DELTA);
        assertEquals(1, GRADIENT.get(point(10, 10)), DELTA);
        assertEquals(sqrt(3 * 3 + 7 * 7) / 10, GRADIENT.get(point(3, 7)), DELTA);
    }
}
