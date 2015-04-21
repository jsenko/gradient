package net.jsenko.pv260.gradient.grid;

import org.junit.Test;

import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static net.jsenko.pv260.gradient.geometry.Point.point;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class GridViewTest {

    private static final ReadOnlyGrid<Integer> TESTING_GRID
            = new TestingGrid();


    @Test(expected = NullPointerException.class)
    public void itShouldFailOnNullUnderlyingGrid() {
        new GridView(null, ZERO, 5, 5);
    }


    @Test(expected = NullPointerException.class)
    public void itShouldFailOnNullOriginPoint() {
        new GridView(TESTING_GRID, null, 5, 5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailOnNegativeSizeX() {
        new GridView(TESTING_GRID, ZERO, -5, 5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailOnNegativeSizeY() {
        new GridView(TESTING_GRID, ZERO, 5, -5);
    }


    @Test
    public void itShouldReturnExpectedCellValues() {
        GridView view = new GridView(TESTING_GRID, point(1, 1), 3, 3);
        assertEquals(TESTING_GRID.get(point(1, 1)), view.get(ZERO));
        assertEquals(TESTING_GRID.get(point(3, 3)), view.get(point(2, 2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailOnOutOfBoundsLocation() {
        GridView view = new GridView(TESTING_GRID, point(1, 1), 3, 3);
        view.get(point(3, 3));
    }
}
