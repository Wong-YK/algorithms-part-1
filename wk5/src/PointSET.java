import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {

    private SET<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        this.points = new SET<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return this.points.isEmpty();}

    // number of points in the set
    public int size() {
        return this.points.size();}

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        this.points.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return this.points.contains(p);}

    // draw all points to standard draw
    public void draw() {
        for (Point2D p: this.points) {
            StdDraw.point(p.x(), p.y());
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        SET<Point2D> result = new SET<Point2D>();
        for (Point2D p: this.points) {
            if (p.x() >= rect.xmin() && p.x() <= rect.xmax() && p.y() >= rect.ymin() && p.y() <= rect.ymin()) {
                result.add(p);
            }
        }
        return result;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        Point2D result = null;
        double min = -1;
        for (Point2D pp: this.points) {
            double distance = p.distanceTo(pp);
            if ( distance < min || min < 0) {
                result = pp;
                min = distance;
            }
        }
        return result;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {}
}
