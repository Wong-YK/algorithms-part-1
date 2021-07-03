import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    // y coords different (greater than)
    public void compareToTest1() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 0);
        assertTrue(p1.compareTo(p2) > 0);
    }

    @Test
    // y coords different (less than)
    public void compareToTest2() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 5);
        assertTrue(p1.compareTo(p2) < 0);
    }

    @Test
    // y coords same, x coords different (greater than)
    public void compareToTest3() {
        Point p1 = new Point(4, 5);
        Point p2 = new Point(1, 5);
        assertTrue(p1.compareTo(p2) > 0);
    }

    @Test
    // y coords same, x coords different (less than)
    public void compareToTest4() {
        Point p1 = new Point(-2, 5);
        Point p2 = new Point(1, 5);
        assertTrue(p1.compareTo(p2) < 0);
    }

    @Test
    // y and x coords same
    public void compareToTest5() {
        Point p1 = new Point(4, 5);
        Point p2 = new Point(4, 5);
        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    // x and y coords not equal; positive gradient
    public void slopeToTest1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point (1, 2);
        assertEquals(2.0, p1.slopeTo(p2), 0.0001);
    }

    @Test
    // x and y coords not equal; negative gradient
    public void slopeToTest2() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point (-1, 3);
        assertEquals(-1.5, p1.slopeTo(p2), 0.0001);
    }

    @Test
    // x coords not equal; y coords equal
    public void slopeToTest3() {
        Point p1 = new Point(0, 2);
        Point p2 = new Point (1, 2);
        Double slope = p1.slopeTo(p2);
        assertTrue(slope.equals(-0.0));
    }

    @Test
    // y coords not equal; x coords equal
    public void slopeToTest4() {
        Point p1 = new Point(-1, 0);
        Point p2 = new Point (-1, 3);
        assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2), 0.0001);
    }

    @Test
    // x and y coords equal
    public void slopeToTest5() {
        Point p1 = new Point(-1, 3);
        Point p2 = new Point (-1, 3);
        assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p2), 0.0001);
    }


    @Test
    // points are equal
    public void compareTest1() {
        Point p = new Point(0, 0);
        Comparator<Point> c = p.slopeOrder();
        Point p1 = new Point(1, 1);
        assertEquals(0, c.compare(p1, p1));
    }

    @Test
    // points not equal but have same slope
    public void compareTest2() {
        Point p = new Point(0, 0);
        Comparator<Point> c = p.slopeOrder();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        assertEquals(0, c.compare(p1, p2));
    }


    @Test
    // p1 has a greater slope than p2
    public void compareTest3() {
        Point p = new Point(1, 0);
        Comparator<Point> c = p.slopeOrder();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        assertEquals(1, c.compare(p1, p2));
    }

    @Test
    // p1 has a smaller slope than p2
    public void compareTest4() {
        Point p = new Point(1, 0);
        Comparator<Point> c = p.slopeOrder();
        Point p1 = new Point(0, 1);
        Point p2 = new Point(2, 2);
        assertEquals(-1, c.compare(p1, p2));
    }

    @Test
    // reflexivity
    public void slopeOrderCompareTest1() {
        Point p = new Point(485, 356);
        Point q = new Point(485, 345);
        assertEquals(0, p.slopeOrder().compare(q, q));

    }

    public static void main(String[] args) {
        System.out.println(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
    }

}
