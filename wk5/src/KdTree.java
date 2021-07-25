import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class KdTree {

    public static class Node {

        Point2D key;
        Node left;
        Node right;

        Node(Point2D p) {
            this.key = p;
            this.left = null;
            this.right = null;
        }

    }

    public Node root;
    public int size;

    // construct an empty set of points
    public KdTree() {
        this.root = null;
        this.size = 0;
    }

    // is the set empty?
    public boolean isEmpty() {return this.size == 0;}

    // number of points in the set
    public int size() {return this.size;}

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        this.root = insert(this.root, p, true);
        this.size++;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {return false;}

    // draw all points to standard draw
    public void draw() {
        Node origin = new Node(new Point2D(0.0, 0.0));
        drawNode(this.root, origin, false, 0.0, 1.0, 0.0, 1.0);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {return null;}

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {return null;}

    private Node insert(Node n, Point2D p, boolean compareX) {
        if (n == null) {
            return new Node(p);
        }
        if (compareX) {
            if (p.x() < n.key.x()) { n.left = insert(n.left, p, false); }
            else if (p.x() > n.key.x()) { n.right = insert(n.right, p, false); }
        }
        else {
            if (p.y() < n.key.y()) { n.left = insert(n.left, p, true); }
            else if (p.y() > n.key.y()) { n.right = insert(n.right, p, true); }
        }
        return n;
    }

    private void drawNode(Node n, Node parent, boolean compareX, double xMin, double xMax, double yMin, double yMax) {
        if (n == null) {
            return;
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(n.key.x(), n.key.y(), 0.01);
        if (compareX) {
            StdDraw.setPenColor(StdDraw.BLUE);
            if (n.key.x() < parent.key.x()) {
                xMax = parent.key.x();
                StdDraw.line(xMin, n.key.y(), parent.key.x(), n.key.y());
            }
            else if (n.key.x() > parent.key.x()) {
                xMin = parent.key.x();
                StdDraw.line(parent.key.x(), n.key.y(), xMax, n.key.y());
            }
            drawNode(n.left, n, false, xMin, xMax, yMin, yMax);
            drawNode(n.right, n, false, xMin, xMax, yMin, yMax);
        }
        else {
            StdDraw.setPenColor(StdDraw.RED);
            if (n.key.y() < parent.key.y()) {
                yMax = parent.key.y();
                StdDraw.line(n.key.x(), yMin, n.key.x(), parent.key.y());
            }
            else if (n.key.y() > parent.key.y()) {
                yMin = parent.key.y();
                StdDraw.line(n.key.x(), parent.key.y(), n.key.x(), yMax);
            }
            drawNode(n.left, n, true, xMin, xMax, yMin, yMax);
            drawNode(n.right, n, true, xMin, xMax, yMin, yMax);
        }
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
    }
}
