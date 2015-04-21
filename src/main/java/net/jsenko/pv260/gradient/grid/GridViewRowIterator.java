package net.jsenko.pv260.gradient.grid;

import java.util.function.BiConsumer;

import net.jsenko.pv260.gradient.geometry.Point;
import net.jsenko.pv260.gradient.grid.GridView;
import static net.jsenko.pv260.gradient.geometry.Point.point;

/**
 * @author Jakub Senko
 */
public class GridViewRowIterator<T> {


    private final GridView<T> view;

    public GridViewRowIterator(GridView<T> view) {
        this.view = view;
    }


    public void iterate(BiConsumer<Point, T> consumer) {
        for (int y = 0; y < view.getHeight(); y++) {
            for (int x = 0; x < view.getWidth(); x++) {
                Point location = point(x, y);
                consumer.accept(location, view.get(location));

            }
            //System.out.println();
        }
    }
}
