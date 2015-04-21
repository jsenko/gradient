package net.jsenko.pv260.gradient.geometry;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
