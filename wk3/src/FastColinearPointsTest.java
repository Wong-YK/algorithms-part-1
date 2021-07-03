import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import static org.junit.Assert.*;

public class FastColinearPointsTest {

    @Test
    // one maximal collinear line segment
    public void segmentsTest1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);
        Point[] points = {p2, p1, p3, p4};
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] ls = fcp.segments();
        assertEquals(1, ls.length);
    }

    @Test
    // two collinear maximal line segments
    public void segmentsTest2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(0,0);
        Point p6 = new Point(-1, 1);
        Point p7 = new Point(-2, 2);
        Point p8 = new Point(-3, 3);
        Point[] points = {p2, p1, p3, p4, p5, p7, p8, p6};
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] ls = fcp.segments();
        assertEquals(2, ls.length);
    }

    @Test
    // input8.txt
    public void segmentsTest3() {
        Point p1 = new Point(10000, 0);
        Point p2 = new Point(0, 10000);
        Point p3 = new Point(3000, 7000);
        Point p4 = new Point(7000, 3000);
        Point p5 = new Point(20000,21000);
        Point p6 = new Point(3000, 4000);
        Point p7 = new Point(14000, 15000);
        Point p8 = new Point(6000, 7000);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8};
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] lineSegments = fcp.segments();
        for (LineSegment ls: lineSegments) {
            StdOut.println(ls);
        }
        assertEquals(2, lineSegments.length);
    }

    @Test
    // input6.txt
    public void segmentsTest4() {
        Point p1 = new Point(19000, 10000);
        Point p2 = new Point(18000, 10000);
        Point p3 = new Point(32000, 10000);
        Point p4 = new Point(21000, 10000);
        Point p5 = new Point(1234,5678);
        Point p6 = new Point(14000, 10000);
        Point[] points = {p1, p2, p3, p4, p5, p6};
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] lineSegments = fcp.segments();
        for (LineSegment ls: lineSegments) {
            StdOut.println(ls);
        }
        assertEquals(1, lineSegments.length);
    }

    @Test
    // one maximal collinear line segment
    public void segmentsTest5() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(3, 3);
        Point[] points = {p2, p1, p3, p4, p5};
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] ls = fcp.segments();
        assertEquals(1, ls.length);
    }


}
