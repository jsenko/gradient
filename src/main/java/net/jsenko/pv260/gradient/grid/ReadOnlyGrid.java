package net.jsenko.pv260.gradient.grid;

import net.jsenko.pv260.gradient.geometry.Point;

/**
 * @author Jakub Senko
 */
public interface ReadOnlyGrid<T> {

    /**
     * No size restrictions.
     * May return null when no data available (or was set to null).
     */
    T get(Point location);
}
