import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

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

    private Node root;
    private int size;

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
    public boolean contains(Point2D p) {
        Node currentNode = this.root;
        boolean compareX = true;
        while (currentNode != null) {
            if (currentNode.key.equals(p)) { return true; }
            if (compareX) {
                if (p.x() < currentNode.key.x()) {
                    currentNode = currentNode.left;
                }
                else if (p.x() > currentNode.key.x()) {
                    currentNode = currentNode.right;
                }
                compareX = false;
            }
            else {
                if (p.y() < currentNode.key.y()) {
                    currentNode = currentNode.left;
                }
                else if (p.y() > currentNode.key.y()) {
                    currentNode = currentNode.right;
                }
                compareX = true;
            }
        }
        return false;
    }

    // draw all points to standard draw
    public void draw() {
        Node origin = new Node(new Point2D(0.0, 0.0));
        drawNode(this.root, origin, false, 0.0, 1.0, 0.0, 1.0);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        ArrayList<Point2D> result = new ArrayList<Point2D>();
        RectHV unitSquare = new RectHV(0.0, 0.0, 1.0, 1.0);
        findPointsContained(this.root, result, rect, unitSquare, false);
        return result;}

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

    private void findPointsContained(Node n, ArrayList<Point2D> a, RectHV qr, RectHV nr, boolean isHorizontal) {
        if (n == null) { return; }
        if (qr.contains(n.key)) { a.add(n.key); }
        RectHV left = pruneTree(nr, n, isHorizontal, true);
        if (qr.intersects(left)) { findPointsContained(n.left, a, qr, left, !isHorizontal); }
        RectHV right = pruneTree(nr, n, isHorizontal, false);
        if (qr.intersects(right)) { findPointsContained(n.right, a, qr, right, !isHorizontal); }
    }

    private RectHV pruneTree(RectHV r, Node n, boolean isHorizontal, boolean isLeft) {
        if (isHorizontal) {
            if (isLeft) { return new RectHV(r.xmin(), r.ymin(), r.xmax(), n.key.y()); }
            else { return new RectHV(r.xmin(), n.key.y(), r.xmax(), r.ymax()); }
        }
        else {
            if (isLeft) { return new RectHV(r.xmin(), r.ymin(), n.key.x(), r.ymax()); }
            else { return new RectHV(n.key.x(), r.ymin(), r.xmax(), r.ymax()); }
        }
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {


    }
}
