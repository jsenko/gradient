package net.jsenko.pv260.gradient.gradient;

import net.jsenko.pv260.gradient.geometry.Point;
import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import static java.lang.Math.min;
import static java.util.Objects.requireNonNull;
import static net.jsenko.pv260.gradient.geometry.Geometry.distance;

/**
 * @author Jakub Senko
 */
public class RadialGradient implements ReadOnlyGrid<Double> {


    private final Point origin;

    private final double radius;


    public RadialGradient(Point origin, int radius) {
        requireNonNull(origin);
        this.origin = origin;
        if (radius < 0)
            throw new IllegalArgumentException("Gradient radius must be non-negative.");
        this.radius = radius;
    }


    @Override
    public Double get(Point location) {
        requireNonNull(location);
        return min(distance(origin, location) / radius, 1);
    }
}
