import org.junit.Test;
import static org.junit.Assert.*;

public class KdTreeTest {

    @Test
    // The root of an empty KdTree is null
    public void KdTreeTest1() {
        KdTree kt = new KdTree();
        assertEquals(null, kt.root);
    }


}
