import java.lang.Math;

public class BruteCollinearPoints {

    private final Point[] points;
    private final LineSegment[] lineSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
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
        int n = this.points.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point p1 = this.points[i];
                        Point p2 = this.points[j];
                        Point p3 = this.points[k];
                        Point p4 = this.points[l];
                        if (aligned(p1, p2, p3, p4)) {
                            result = append(result, maxSeg(p1, p2, p3, p4));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static LineSegment[] append(LineSegment[] oldArray, LineSegment lineSegment) {
        LineSegment[] newArray = new LineSegment[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = lineSegment;
        return newArray;
    }

    private static boolean aligned(Point p1, Point p2, Point p3, Point p4) {
        double p1p2 = p1.slopeTo(p2);
        double p1p3 = p1.slopeTo(p3);
        double p1p4 = p1.slopeTo(p4);
        return (Math.abs(p1p2 - p1p3) < 0.0000001 && Math.abs(p1p3 - p1p4) < 0.0001) ||
                p1p2 == p1p3 && p1p3 == p1p4;
    }

    private static LineSegment maxSeg(Point p1, Point p2, Point p3, Point p4) {
        Point[] points = {p1, p2, p3, p4};
        Point hi = p1;
        Point lo = p1;
        for (Point p: points) {
            if (p.compareTo(hi) > 0) hi = p;
            if (p.compareTo(lo) < 0) lo = p;
        }
        return new LineSegment(lo, hi);
    }

}