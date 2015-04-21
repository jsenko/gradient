package net.jsenko.pv260.gradient.cli;

import net.jsenko.pv260.gradient.colors.CharColorized;
import net.jsenko.pv260.gradient.colors.CharColors;
import net.jsenko.pv260.gradient.grid.GridView;
import net.jsenko.pv260.gradient.grid.GridViewRowIterator;
import net.jsenko.pv260.gradient.gradient.LinearGradient;
import net.jsenko.pv260.gradient.geometry.Point;
import net.jsenko.pv260.gradient.gradient.RadialGradient;
import net.jsenko.pv260.gradient.grid.ReadOnlyGrid;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.geometry.Point.point;

/**
 * @author Jakub Senko
 */
public class Handler {

    private ReadOnlyGrid<Double> gradient;

    private CharColorized colorized;

    private GridView<Character> view;

    private int displayX;

    private int displayY;

    private CharColors colors;


    public void displaySize(int x, int y) {
        displayX = x;
        displayY = y;
    }


    public void colors(String s) {
        colors = new CharColors(s);
    }


    public void radial(int x, int y, int r) {
        gradient = new RadialGradient(point(x, y), r);
        display();
    }


    public void linear(int x1, int y1, int x2, int y2) {
        gradient = new LinearGradient(point(x1, y1), point(x2, y2));
        display();
    }


    public void display() {

        colorized = new CharColorized(gradient, colors);
        view = new GridView<>(colorized, Point.ZERO, displayX, displayY);

        GridViewRowIterator<Character> it = new GridViewRowIterator<>(view);
        it.iterate((location, character) -> {
            out.print(character);
            if ((location.getX() % view.getWidth())
                    == (view.getWidth() - 1))
                out.println();
        });
    }
}
