package net.jsenko.pv260.gradient.gradient;

import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import net.jsenko.pv260.gradient.geometry.Point;
import static java.lang.Math.*;
import static net.jsenko.pv260.gradient.geometry.Geometry.*;

/**
 * @author Jakub Senko
 */
public class LinearGradient implements ReadOnlyGrid<Double> {


    private final Point origin;

    private final Point end;


    public LinearGradient(Point origin, Point end) {
        this.origin = origin;
        this.end = end;
    }


    @Override
    public Double get(Point location) {

        // Vector projection
        Point u = sub(location, origin);
        Point v = sub(end, origin);
        double z = dot(u, v) / dot(v, v);

        return max(0, min(z, 1));
    }
}
