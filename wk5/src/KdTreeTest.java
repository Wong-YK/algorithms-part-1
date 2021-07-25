import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Point2D;

public class KdTreeTest {

    @Test
    // The root of an empty KdTree is null
    public void KdTreeTest1() {
        KdTree kdt = new KdTree();
        assertEquals(null, kdt.root);
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
        kdt.draw();
        kdt.insert(p2);
        kdt.draw();
        kdt.insert(p3);
        kdt.draw();
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


    /*
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
    */


}
