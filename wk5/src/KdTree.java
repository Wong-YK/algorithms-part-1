import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

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
    public boolean isEmpty() {return false;}

    // number of points in the set
    public int size() {return -1;}

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {}

    // does the set contain point p?
    public boolean contains(Point2D p) {return false;}

    // draw all points to standard draw
    public void draw() {}

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {return null;}

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {return null;}

    // unit testing of the methods (optional)
    public static void main(String[] args) {}
}
