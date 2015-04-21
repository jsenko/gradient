package net.jsenko.pv260.gradient.geometry;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static net.jsenko.pv260.gradient.geometry.Geometry.distance;
import static net.jsenko.pv260.gradient.geometry.Geometry.dot;
import static net.jsenko.pv260.gradient.geometry.Geometry.sub;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Jakub Senko
 */
public class PointTest {

    private static final double DELTA = 0.000001;


    @Test
    public void itShouldComparePointsCorrectly() {
        assertEquals(ZERO, point(0, 0));
        assertNotEquals(point(-1, -1), point(-1, 1));
    }


    @Test
    public void itShouldComputeHashCodeCorrectly() {
        assertEquals(ZERO.hashCode(), point(0, 0).hashCode());
    }
}
