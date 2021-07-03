import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void isEmptyTest1() {
        Deque<Integer> d = new Deque<Integer>();
        assertTrue(d.isEmpty());
        d.addFirst(1);
        assertFalse(d.isEmpty());
        d.addFirst(2);
        assertFalse((d.isEmpty()));
        d.removeFirst();
        d.removeFirst();
        assertTrue(d.isEmpty());
    }
}
