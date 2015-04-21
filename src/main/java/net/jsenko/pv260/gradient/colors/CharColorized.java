package net.jsenko.pv260.gradient.colors;

import net.jsenko.pv260.gradient.geometry.Point;
import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import static java.util.Objects.requireNonNull;

/**
 * @author Jakub Senko
 */
public class CharColorized implements ReadOnlyGrid<Character> {


    private final ReadOnlyGrid<Double> grid;

    private final Colors colors;

    public CharColorized(ReadOnlyGrid<Double> grid, Colors colors) {
        requireNonNull(grid);
        requireNonNull(colors);
        this.grid = grid;
        this.colors = colors;
    }


    @Override
    public Character get(Point location) {
        requireNonNull(location);
        return colors.color(grid.get(location));
    }
}
