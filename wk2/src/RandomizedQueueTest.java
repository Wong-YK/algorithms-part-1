import org.junit.Test;
import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void RandomizedQueueTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertEquals(0, rq.size());
    }

    @Test
    public void isEmptyTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertTrue(rq.isEmpty());
    }

    @Test
    public void sizeTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        assertEquals(0, rq.size());
    }

    @Test
    public void sizeTest2() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(1);
        assertEquals(1, rq.size());
    }

    @Test
    public void sizeTest3() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(13);
        rq.enqueue(22);
        assertEquals(2, rq.size());
    }

    @Test
    public void enqueueTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (int i = 1; i <= 5; i++) {
            rq.enqueue(i);
        }
        assertEquals(5, rq.size());
    }

    @Test
    public void enqueueTest2() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(10);
        rq.dequeue();
        rq.enqueue(11);
        assertEquals(1, rq.size());
    }


    @Test
    public void dequeueTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (int i = 1; i <= 5; i++) {
            rq.enqueue(i);
        }
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        assertEquals(2, rq.size());
    }

    /*
    @Test
    public void resizeTest1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            rq.enqueue(i);
        }
        for (int i = 0; i < 3; i++) {
            rq.dequeue();
        }
        assertEquals(4, rq.capacity);
    }
    */



}
