package net.jsenko.pv260.gradient.geometry;

import static java.lang.Math.*;
import static net.jsenko.pv260.gradient.geometry.Point.point;

/**
 * @author Jakub Senko
 */
public class Geometry {


    public static Point sub(Point a, Point b) {
        return point(a.getX() - b.getX(), a.getY() - b.getY());
    }


    public static double distance(Point first, Point second) {
        return sqrt(pow(second.getX() - first.getX(), 2)
                + pow(second.getY() - first.getY(), 2));
    }


    public static double dot(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }
}
