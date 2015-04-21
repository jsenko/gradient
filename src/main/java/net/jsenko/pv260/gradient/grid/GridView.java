package net.jsenko.pv260.gradient.grid;

import net.jsenko.pv260.gradient.geometry.Point;
import static net.jsenko.pv260.gradient.geometry.Point.point;

/**
 * @author Jakub Senko
 */
public class GridView<T> implements ReadOnlyGrid<T> {


    private final ReadOnlyGrid<T> grid;

    private final Point origin;

    private final int width;

    private final int height;


    public GridView(ReadOnlyGrid<T> grid, Point origin, int width, int height) {
        this.grid = grid;
        this.origin = origin;
        this.width = width;
        this.height = height;
    }


    public T get(Point location) {
        return grid.get(point(origin.getX() + location.getX(),
                origin.getY() + location.getY()));
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }
}
