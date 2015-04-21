package net.jsenko.pv260.gradient.grid;

import java.util.Objects;

import net.jsenko.pv260.gradient.geometry.Point;
import static java.util.Objects.requireNonNull;
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
        Objects.requireNonNull(grid);
        this.grid = grid;
        Objects.requireNonNull(origin);
        this.origin = origin;
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("GridView size must be non-negative.");
        }
        this.width = width;
        this.height = height;
    }


    /**
     * Throws an exception if the location is not within the view.
     */
    public T get(Point location) {
        requireNonNull(location);
        if (location.getX() < 0
                || location.getX() >= width
                || location.getY() < 0
                || location.getY() >= height)
            throw new IllegalArgumentException("Location is not within the GridView boundaries.");

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
