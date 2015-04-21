package net.jsenko.pv260.gradient.gradient;

import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import net.jsenko.pv260.gradient.geometry.Point;
import static java.lang.Math.min;
import static net.jsenko.pv260.gradient.geometry.Geometry.distance;

/**
 * @author Jakub Senko
 */
public class RadialGradient implements ReadOnlyGrid<Double> {


    private final Point origin;

    private final double radius;


    public RadialGradient(Point origin, int radius) {
        this.origin = origin;
        this.radius = radius;
    }


    @Override
    public Double get(Point location) {
        return min(distance(origin, location) / radius, 1);
    }
}