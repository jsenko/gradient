package net.jsenko.pv260.gradient.grid;

import net.jsenko.pv260.gradient.geometry.Point;

/**
 * @author Jakub Senko
 */
public interface ReadOnlyGrid<T> {


    T get(Point location);
}
