package net.jsenko.pv260.gradient.geometry;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static net.jsenko.pv260.gradient.geometry.Geometry.distance;
import static net.jsenko.pv260.gradient.geometry.Geometry.dot;
import static net.jsenko.pv260.gradient.geometry.Geometry.sub;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class GeometryTest {

    private static final double DELTA = 0.000001;


    @Test
    public void itShouldComputeVectorDifferenceCorrectly() {
        assertEquals(ZERO, sub(ZERO, ZERO));
        assertEquals(point(-2, 2), sub(point(-1, 1), point(1, -1)));
        assertEquals(point(-1, 1), sub(ZERO, sub(ZERO, point(-1, 1))));
    }


    @Test
    public void itShouldComputeDistanceCorrectly() {
        assertEquals(0, distance(ZERO, ZERO), DELTA);
        assertEquals(sqrt(2), distance(ZERO, point(1, 1)), DELTA);
        assertEquals(sqrt(2), distance(point(-1, -1), ZERO), DELTA);
        assertEquals(2, distance(point(-1, 0), point(1, 0)), DELTA);
        assertEquals(sqrt(8), distance(point(-1, -1), point(1, 1)), DELTA);
    }

    @Test
    public void itShouldComputeDotProductCorrectly() {
        assertEquals(0, dot(ZERO, ZERO), DELTA);
        assertEquals(0, dot(point(-1, 1), point(1, 1)), DELTA); // orthogonal
        assertEquals(-2, dot(point(-1, -1), point(1, 1)), DELTA);
    }
}
