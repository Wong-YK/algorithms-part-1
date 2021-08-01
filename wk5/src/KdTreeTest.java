import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;

public class KdTreeTest {

    @Test
    // KdTree initialised as empty
    public void KdTreeTest1() {
        KdTree kdt = new KdTree();
        assertTrue(kdt.isEmpty());
    }

    @Test
    // empty BST
    public void isEmptyTest1() {
        KdTree kdt = new KdTree();
        assertTrue(kdt.isEmpty());
    }

    @Test
    // non-empty BST
    public void isEmptyTest2() {
        KdTree kdt = new KdTree();
        kdt.insert(new Point2D(0.3, 0.2));
        assertFalse(kdt.isEmpty());
    }

    @Test
    // BST of size 0
    public void sizeTest1() {
        KdTree kdt = new KdTree();
        assertEquals(0, kdt.size());
    }

    @Test
    // BST of size 5
    public void sizeTest2() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.7, 0.7);
        Point2D p3 = new Point2D(0.8, 0.3);
        Point2D p4 = new Point2D(0.65, 0.2);
        Point2D p5 = new Point2D(0.3, 0.1);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        assertEquals(5, kdt.size());
    }

    @Test
    // BST of size 10
    public void sizeTest3() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.7, 0.7);
        Point2D p3 = new Point2D(0.8, 0.3);
        Point2D p4 = new Point2D(0.65, 0.2);
        Point2D p5 = new Point2D(0.3, 0.7);
        Point2D p6 = new Point2D(0.2, 0.2);
        Point2D p7 = new Point2D(0.1, 0.5);
        Point2D p8 = new Point2D(0.1, 0.9);
        Point2D p9 = new Point2D(0.7, 0.6);
        Point2D p10 = new Point2D(0.95, 0.2);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        kdt.insert(p7);
        kdt.insert(p8);
        kdt.insert(p9);
        kdt.insert(p10);
        assertEquals(10, kdt.size());
    }


    @Test
    // Insert single Point2D into BST
    public void insertTest1() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        kdt.insert(p1);
        kdt.draw();
    }

    @Test
    // Insert 4 Point2Ds into BST
    public void insertTest2() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.7, 0.7);
        Point2D p3 = new Point2D(0.8, 0.3);
        Point2D p4 = new Point2D(0.65, 0.2);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.draw();
    }

    @Test
    // Insert 10 Point2Ds into BST
    public void insertTest3() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.7, 0.7);
        Point2D p3 = new Point2D(0.8, 0.3);
        Point2D p4 = new Point2D(0.65, 0.2);
        Point2D p5 = new Point2D(0.3, 0.7);
        Point2D p6 = new Point2D(0.2, 0.2);
        Point2D p7 = new Point2D(0.1, 0.5);
        Point2D p8 = new Point2D(0.1, 0.9);
        Point2D p9 = new Point2D(0.7, 0.6);
        Point2D p10 = new Point2D(0.95, 0.2);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        kdt.insert(p7);
        kdt.insert(p8);
        kdt.insert(p9);
        kdt.insert(p10);
        kdt.draw();
    }

    @Test
    // Search for node in KdTree of size 1 containing that node
    public void containsTest1() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.5, 0.5);
        kdt.insert(p1);
        assertTrue(kdt.contains(p2));
    }

    @Test
    // Search for node in KdTree of size 1 not containing that node
    public void containsTest2() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.6, 0.75);
        kdt.insert(p1);
        assertFalse(kdt.contains(p2));
    }

    @Test
    // Search for node in KdTree of size 5 containing that node
    public void containsTest3() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.8, 0.3);
        Point2D p2 = new Point2D(0.5, 0.5);
        Point2D p3 = new Point2D(0.6, 0.75);
        Point2D p4 = new Point2D(0.2, 0.1);
        Point2D p5 = new Point2D(0.1, 0.95);
        Point2D p6 = new Point2D(0.8, 0.3);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        assertTrue(kdt.contains(p1));
    }

    @Test
    // Search for node in KdTree of size 5 not containing that node
    public void containsTest4() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.63, 0.43);
        Point2D p2 = new Point2D(0.5, 0.5);
        Point2D p3 = new Point2D(0.6, 0.75);
        Point2D p4 = new Point2D(0.2, 0.1);
        Point2D p5 = new Point2D(0.1, 0.95);
        Point2D p6 = new Point2D(0.8, 0.3);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        assertFalse(kdt.contains(p1));
    }

    @Test
    // draw an example KdTree with 4 nodes
    public void drawTest1() {
        KdTree kdt = new KdTree();
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.7, 0.7);
        Point2D p3 = new Point2D(0.8, 0.3);
        Point2D p4 = new Point2D(0.65, 0.2);
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.draw();
    }

    @Test
    // draw an example KdTree with 5 nodes
    public void drawTest2() {
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

    @Test
    // KdTree of size 1 with point enclosed by rectangle
    public void rangeTest1() {
        RectHV r = new RectHV(0.2, 0.2, 0.7, 0.7);
        Point2D p1 = new Point2D(0.5, 0.5);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        ArrayList<Point2D> points = (ArrayList<Point2D>) kdt.range(r);
        assertTrue(points.contains(p1));
    }

    @Test
    // KdTree of size 1 with point not enclosed by rectangle
    public void rangeTest2() {
        RectHV r = new RectHV(0.4, 0.4, 0.6, 0.6);
        Point2D p1 = new Point2D(0.1, 0.2);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        ArrayList<Point2D> points = (ArrayList<Point2D>) kdt.range(r);
        assertFalse(points.contains(p1));
    }

    @Test
    // KdTree of size 5 with 2 points enclosed by rectangle
    public void rangeTest3() {
        RectHV r = new RectHV(0.6, 0.0, 1.0, 1.0);
        Point2D p1 = new Point2D(0.2, 0.2);
        Point2D p2 = new Point2D(0.1, 0.8);
        Point2D p3 = new Point2D(0.5, 0.4);
        Point2D p4 = new Point2D(0.7, 0.9);
        Point2D p5 = new Point2D(0.9, 0.5);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        ArrayList<Point2D> points = (ArrayList<Point2D>) kdt.range(r);
        assertFalse(points.contains(p1));
        assertFalse(points.contains(p2));
        assertFalse(points.contains(p3));
        assertTrue(points.contains(p4));
        assertTrue(points.contains(p5));
    }

    @Test
    // KdTree of size 10 with 5 points enclosed by rectangle
    public void rangeTest4() {
        RectHV r = new RectHV(0.05, 0.1, 0.4, 0.9);
        Point2D p1 = new Point2D(0.2, 0.2);
        Point2D p2 = new Point2D(0.1, 0.8);
        Point2D p3 = new Point2D(0.5, 0.4);
        Point2D p4 = new Point2D(0.7, 0.9);
        Point2D p5 = new Point2D(0.9, 0.5);
        Point2D p6 = new Point2D(0.8, 0.1);
        Point2D p7 = new Point2D(0.15, 0.6);
        Point2D p8 = new Point2D(0.05, 0.85);
        Point2D p9 = new Point2D(0.3, 0.3);
        Point2D p10 = new Point2D(0.85, 0.95);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        kdt.insert(p7);
        kdt.insert(p8);
        kdt.insert(p9);
        kdt.insert(p10);
        ArrayList<Point2D> points = (ArrayList<Point2D>) kdt.range(r);
        assertTrue(points.contains(p1));
        assertTrue(points.contains(p2));
        assertFalse(points.contains(p3));
        assertFalse(points.contains(p4));
        assertFalse(points.contains(p5));
        assertFalse(points.contains(p6));
        assertTrue(points.contains(p7));
        assertTrue(points.contains(p8));
        assertTrue(points.contains(p9));
        assertFalse(points.contains(p10));
    }

    @Test
    // Nearest neighbour in KdTree of size 1
    public void nearestTest1() {
        Point2D p = new Point2D(0.2, 0.3);
        KdTree kdt = new KdTree();
        kdt.insert(p);
        Point2D qp = new Point2D(0.7, 0.7);
        assertEquals(p, kdt.nearest(qp));
    }

    @Test
    // Nearest neighbour in rhs KdTree of size 2
    public void nearestTest2() {
        Point2D p1 = new Point2D(0.2, 0.3);
        Point2D p2 = new Point2D(0.6,  0.5);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        Point2D qp = new Point2D(0.7, 0.7);
        assertEquals(p2, kdt.nearest(qp));
    }

    @Test
    // Nearest neighbour in rhs of KdTree of size 5
    public void nearestTest3() {
        Point2D p1 = new Point2D(0.2, 0.3);
        Point2D p2 = new Point2D(0.6,  0.5);
        Point2D p3 = new Point2D(0.1, 0.8);
        Point2D p4 = new Point2D(0.9, 0.1);
        Point2D p5 = new Point2D(0.5, 0.85);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        Point2D qp = new Point2D(0.7, 0.7);
        assertEquals(p2, kdt.nearest(qp));
    }

    @Test
    // Nearest neighbour in lhs of KdTree of size 5
    public void nearestTest4() {
        Point2D p1 = new Point2D(0.2, 0.3);
        Point2D p2 = new Point2D(0.6,  0.5);
        Point2D p3 = new Point2D(0.1, 0.8);
        Point2D p4 = new Point2D(0.9, 0.1);
        Point2D p5 = new Point2D(0.5, 0.85);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        Point2D qp = new Point2D(0.15, 0.7);
        assertEquals(p3, kdt.nearest(qp));
    }

    @Test
    // Nearest neighbour in lhs of KdTree of size 10
    public void nearestTest5() {
        Point2D p1 = new Point2D(0.2, 0.2);
        Point2D p2 = new Point2D(0.1, 0.8);
        Point2D p3 = new Point2D(0.5, 0.4);
        Point2D p4 = new Point2D(0.7, 0.9);
        Point2D p5 = new Point2D(0.9, 0.5);
        Point2D p6 = new Point2D(0.8, 0.1);
        Point2D p7 = new Point2D(0.15, 0.6);
        Point2D p8 = new Point2D(0.05, 0.85);
        Point2D p9 = new Point2D(0.3, 0.3);
        Point2D p10 = new Point2D(0.85, 0.95);
        KdTree kdt = new KdTree();
        kdt.insert(p1);
        kdt.insert(p2);
        kdt.insert(p3);
        kdt.insert(p4);
        kdt.insert(p5);
        kdt.insert(p6);
        kdt.insert(p7);
        kdt.insert(p8);
        kdt.insert(p9);
        kdt.insert(p10);
        Point2D qp = new Point2D(0.2, 0.5);
        assertEquals(p7, kdt.nearest(qp));
    }
}
