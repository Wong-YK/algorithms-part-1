import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;
import java.lang.Math;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    // constructs the point (x, y)
    public Point(int x, int y)        {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.point(x, y);
    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y != that.y) {
            return this.y - that.y;
        }
        else if (this.x != that.x) {
            return this.x - that.x;
        }
        else {
            return 0;
        }
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        if (this.compareTo(that) == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        else if (this.y == that.y) {
            return +0.0;
        }
        else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;

        }
        else {
            return (double) (that.y - this.y) / (that.x - this.x);
        }
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        return new BySlope(this);
    }

    private static class BySlope implements Comparator<Point> {

        Point p;

        BySlope(Point p) {
            this.p = p;
        }

        public int compare(Point p1, Point p2) {
            double pp1 = this.p.slopeTo(p1);
            double pp2 = this.p.slopeTo(p2);
            if (Math.abs(pp1 - pp2) < 0.0000001 || pp1 == pp2) {
                return 0;
            }
            else if (pp1 > pp2) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1, 1);
        Point[] pa1 = {p1, p2};
        Point[] pa2 = {p1, p2};
        System.out.println(pa1[0].equals(pa2[0]));
    }

}