package net.jsenko.pv260.gradient.grid;

import java.util.function.BiConsumer;

import org.junit.Test;

import net.jsenko.pv260.gradient.geometry.Point;
import static net.jsenko.pv260.gradient.geometry.Point.ZERO;
import static org.junit.Assert.assertEquals;

/**
 * @author Jakub Senko
 */
public class GridViewRowIteratorTest {

    private static final ReadOnlyGrid<Integer> TESTING_GRID
            = new TestingGrid();

    private static final GridView<Integer> TESTING_VIEW
            = new GridView(TESTING_GRID, ZERO, 5, 5);


    @Test(expected = NullPointerException.class)
    public void itShouldFailOnNullGridView() {
        new GridViewRowIterator<>(null);
    }


    @Test
    public void itShouldIterateOverAllCells() {

        class TestConsumer implements BiConsumer<Point, Integer> {
            int count;

            @Override
            public void accept(Point point, Integer integer) {
                assertEquals(integer, (Integer) (point.getX() + point.getY()));
                count++;
            }
        }

        TestConsumer testConsumer = new TestConsumer();
        new GridViewRowIterator<>(TESTING_VIEW).iterate(testConsumer);

        assertEquals(TESTING_VIEW.getHeight() * TESTING_VIEW.getWidth(), testConsumer.count);
    }
}
