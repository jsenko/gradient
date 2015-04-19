package net.jsenko.pv260.gradient;

/**
 * @author Jakub Senko
 */
public class CharColorized implements ReadOnlyGrid<Character> {


    private final ReadOnlyGrid<Double> grid;

    private final CharColors charColors;

    public CharColorized(ReadOnlyGrid<Double> grid, CharColors charColors) {
        this.grid = grid;
        this.charColors = charColors;
    }


    @Override
    public Character get(Point location) {
        return charColors.color(grid.get(location));
    }
}
