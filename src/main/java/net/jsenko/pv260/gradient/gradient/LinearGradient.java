package net.jsenko.pv260.gradient.gradient;

import net.jsenko.pv260.gradient.geometry.Point;
import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Objects.requireNonNull;
import static net.jsenko.pv260.gradient.geometry.Geometry.dot;
import static net.jsenko.pv260.gradient.geometry.Geometry.sub;

/**
 * @author Jakub Senko
 */
public class LinearGradient implements ReadOnlyGrid<Double> {


    private final Point origin;

    private final Point end;


    public LinearGradient(Point origin, Point end) {
        requireNonNull(origin);
        requireNonNull(end);
        if (origin.equals(end))
            throw new IllegalArgumentException("Gradient points must not be the same.");
        this.origin = origin;
        this.end = end;
    }


    @Override
    public Double get(Point location) {
        requireNonNull(location);
        // Vector projection
        Point u = sub(location, origin);
        Point v = sub(end, origin);
        double z = dot(u, v) / dot(v, v);

        return max(0, min(z, 1));
    }
}
