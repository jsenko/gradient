package net.jsenko.pv260.gradient;

/**
 * @author Jakub Senko
 */
public interface ReadOnlyGrid<T> {


    T get(Point location);
}
