import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import static org.junit.Assert.*;

public class BruteCollinearPointsTest {

    @Test
    // input8.txt
    public void segmentsTest1() {
        Point p1 = new Point(10000, 0);
        Point p2 = new Point(0, 10000);
        Point p3 = new Point(3000, 7000);
        Point p4 = new Point(7000, 3000);
        Point p5 = new Point(20000,21000);
        Point p6 = new Point(3000, 4000);
        Point p7 = new Point(14000, 15000);
        Point p8 = new Point(6000, 7000);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8};
        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        LineSegment[] lineSegments = bcp.segments();
        for (LineSegment ls: lineSegments) {
            StdOut.println(ls);
        }
        assertEquals(1, lineSegments.length);
    }

    @Test
    // input8.txt
    public void segmentsTest2() {
        Point p1 = new Point(1000, 17000);
        Point p2 = new Point(1000, 27000);
        Point p3 = new Point(1000, 28000);
        Point p4 = new Point(1000, 31000);
        Point[] points = {p1, p2, p3, p4};
        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        LineSegment[] lineSegments = bcp.segments();
        for (LineSegment ls: lineSegments) {
            StdOut.println(ls);
        }
        //assertEquals(1, lineSegments.length);
    }

}
