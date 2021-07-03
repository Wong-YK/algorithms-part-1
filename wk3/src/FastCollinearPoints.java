import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class FastCollinearPoints {

    private final Point[] points;
    private final LineSegment[] lineSegments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (Point point: points) {
            if (point == null) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        Arrays.sort(points);
        this.points = points;
        this.lineSegments = this.segments();
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] result = new LineSegment[0];
        for (int i = 0; i < this.points.length; i++) {
            Point p = this.points[i];
            Point[] copy = deepCopy(this.points);
            Arrays.sort(copy, p.slopeOrder());
            for (int j = 1; j < this.points.length;) {
                Point q = copy[j];
                Point[] collinearPoints = new Point[0];
                while (p.slopeTo(q) == p.slopeTo(copy[j])) {
                    collinearPoints = appendPoint(collinearPoints, copy[j]);
                    j++;
                    if (j > this.points.length - 1) {
                        break;
                    }
                }
                if (collinearPoints.length >= 3) {
                    //collinearPoints = appendPoint(collinearPoints, p);
                    //Arrays.sort(collinearPoints);
                    if (p.compareTo(collinearPoints[0]) < 0) {
                        LineSegment ls = new LineSegment(p, collinearPoints[collinearPoints.length -1]);
                        result = appendLS(result, ls);
                    }
                }
            }
        }
        return result;
    }

    private static Point[] appendPoint(Point[] oldArray, Point obj) {
        Point[] newArray = new Point[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length - 1] = obj;
        return newArray;
    }

    private static LineSegment[] appendLS(LineSegment[] oldArray, LineSegment obj) {
        LineSegment[] newArray = new LineSegment[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length - 1] = obj;
        return newArray;
    }

    private static Point[] deepCopy(Point[] original) {
        Point[] result = new Point[original.length];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }


}