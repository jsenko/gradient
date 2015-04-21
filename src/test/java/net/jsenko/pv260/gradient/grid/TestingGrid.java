package net.jsenko.pv260.gradient.grid;

import net.jsenko.pv260.gradient.geometry.Point;

/**
 * Special grid with predetermined values.
 *
 * @author Jakub Senko
 */
public class TestingGrid implements ReadOnlyGrid<Integer> {

    @Override
    public Integer get(Point location) {
        if (location.getX() >= -10
                && location.getX() <= 10
                && location.getY() >= -10
                && location.getY() <= 10)
            return location.getX() + location.getY();
        else
            return null;
    }
}
