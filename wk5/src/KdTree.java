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
        drawNode(this.root, origin, false);
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

    private void drawNode(Node n, Node parent, boolean compareX) {
        if (n == null) {
            return;
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(n.key.x(), n.key.y(), 0.01);
        if (compareX) {
            StdDraw.setPenColor(StdDraw.BLUE);
            if (n.key.x() < parent.key.x()) { StdDraw.line(0.0, n.key.y(), parent.key.x(), n.key.y()); }
            else if (n.key.x() > parent.key.x()) { StdDraw.line(parent.key.x(), n.key.y(), 1.0, n.key.y()); }
            drawNode(n.left, n, false);
            drawNode(n.right, n, false);
        }
        else {
            StdDraw.setPenColor(StdDraw.RED);
            if (n.key.y() < parent.key.y()) { StdDraw.line(n.key.x(), 0.0, n.key.x(), parent.key.y()); }
            else if (n.key.y() > parent.key.y()) { StdDraw.line(n.key.x(), parent.key.y(), n.key.x(), 1.0); }
            drawNode(n.left, n, true);
            drawNode(n.right, n, true);
        }
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.7, 0.2);
        Point2D p2 = new Point2D(0.5, 0.4);
        Point2D p3 = new Point2D(0.2, 0.3);
        Point2D p4 = new Point2D(0.4, 0.7);
        Point2D p5 = new Point2D(0.9, 0.6);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.draw();
    }
}
