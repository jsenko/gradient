package net.jsenko.pv260.gradient;

/**
 * @author Jakub Senko
 */
public class Point {

    public static Point ZERO = point(0, 0);


    private int x;


    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point point(int x, int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
