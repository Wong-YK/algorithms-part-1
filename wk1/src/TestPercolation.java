import org.junit.Test;
import static org.junit.Assert.*;

/*
public class TestPercolation {

    //constructor creates grid of correct dimensions
    @Test
    public void PercolationTest1() {
        Percolation p = new Percolation(10);
        assertEquals(10, p.grid.length);
        assertEquals(10, p.grid[0].length);
    }

    //constructor creates connections between virtual nodes and top/bottom rows of grid
    @Test
    public void PercolationTest2() {
        Percolation p = new Percolation(4);
        int topVirtualNodeRoot = p.wquf.find(0);
        int botVirtualNodeRoot = p.wquf.find(17);
        for (int i = 1, j = 13; i <= 4; i++, j++) {
            assertEquals(topVirtualNodeRoot, p.wquf.find(i));
            assertEquals(botVirtualNodeRoot, p.wquf.find(j));
        }
    }

    //constructor throws IllegalArgumentException when n <= 0
    @Test (expected = IllegalArgumentException.class)
    public void PercolationTest3() {
        Percolation p = new Percolation(-5);
    }


    //no neighbouring open sites
    @Test
    public void openTest1() {
        int[][] expected = new int[3][3];
        expected[1][1] = 5;
        Percolation p = new Percolation(3);
        p.open(2, 2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], p.grid[i][j]);
            }
        }
        for (int i = 1; i <= 3 * 3; i++) {
            if (i <= 3) {
                assertEquals(p.wquf.find(0), p.wquf.find(i));
            }
            else if (i >= (3 * 2) + 1) {
                assertEquals(p.wquf.find((3 * 3) + 1), p.wquf.find(i));
            }
            else {
                assertEquals(i, p.wquf.find(i));
            }
        }
    }

    //all neighbouring sites open
    @Test
    public void openTest2() {
        int[][] expected = new int[4][4];
        expected[1][1] = 6;
        expected[2][0] = 9;
        expected[2][1] = 10;
        expected[2][2] = 11;
        expected[3][1] = 14;
        Percolation p = new Percolation(4);
        p.open(2, 2);
        p.open(3, 1);
        p.open(3, 3);
        p.open(4, 2);
        p.open(3, 2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], p.grid[i][j]);
            }
        }
        int[] connectedSites = {6, 9, 10, 11, 14};
        int commonRoot = p.wquf.find(10);
        for (int site: connectedSites) {
            assertEquals(commonRoot, p.wquf.find(site));
        }
        assertNotEquals(commonRoot, p.wquf.find(1));
    }

    //top and rhs neighbouring sites are open only
    @Test
    public void openTest3() {
        int[][] expected = new int[4][4];
        expected[1][1] = 6;
        expected[2][1] = 10;
        expected[2][2] = 11;
        Percolation p = new Percolation(4);
        p.open(2, 2);
        p.open(3, 3);
        p.open(3, 2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], p.grid[i][j]);
            }
        }
        int[] connectedSites = {6, 10, 11};
        int commonRoot = p.wquf.find(10);
        for (int site: connectedSites) {
            assertEquals(commonRoot, p.wquf.find(site));
        }
        assertNotEquals(commonRoot, p.wquf.find(9));
        assertNotEquals(commonRoot, p.wquf.find(14));
    }

    //row and col outside of specified range
    @Test (expected = IllegalArgumentException.class)
    public void openTest4() {
        Percolation p = new Percolation(4);
        p.open(5, 5);
    }

    //site is open
    @Test
    public void isOpenTest1() {
        Percolation p = new Percolation(5);
        p.open(3, 4);
        assertTrue(p.isOpen(3, 4));
    }

    @Test
    public void isOpenTest2() {
        Percolation p = new Percolation(5);
        p.open(3, 4);
        assertFalse(p.isOpen(3, 3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isOpenTest3() {
        Percolation p = new Percolation(2);
        p.isOpen(0, 3);
    }

    //site full but system does not percolate
    @Test
    public void isFullTest1() {
        Percolation p = new Percolation(4);
        p.open(1, 2);
        p.open(2, 2);
        p.open(3, 2);
        assertTrue(p.isFull(1, 2));
    }

    //site full and percolates
    @Test
    public void isFullTest2() {
        Percolation p = new Percolation(4);
        p.open(1, 2);
        p.open(2, 2);
        p.open(2, 3);
        p.open(3, 3);
        p.open(4, 3);
        assertTrue(p.isFull(1, 2));
    }

    //site open but not full
    @Test
    public void isFullTest3() {
        Percolation p = new Percolation(4);
        p.open(2, 2);
        p.open(2, 3);
        p.open(3, 3);
        p.open(4, 3);
        assertFalse(p.isFull(2, 2));
    }

    //site not open
    @Test
    public void isFullTest4() {
        Percolation p = new Percolation(4);
        p.open(2, 3);
        p.open(3, 3);
        p.open(4, 3);
        assertFalse(p.isFull(2, 2));
    }

    //row/col outside of specified range
    @Test (expected = IllegalArgumentException.class)
    public void isFullTest5() {
        Percolation p = new Percolation(4);
        p.isFull(6, 1);
    }

    //no open sites
    @Test
    public void numberOfOpenSitesTest1() {
        Percolation p = new Percolation(5);
        assertEquals(0, p.numberOfOpenSites());
    }

    //multiple open sites
    @Test
    public void numberOfOpenSitesTest2() {
        Percolation p = new Percolation(3);
        p.open(1,1);
        p.open(1, 2);
        p.open(3,3);
        p.open(3, 1);
        p.open(2, 3);
        assertEquals(5, p.numberOfOpenSites());
    }

    //one open site on which open has been called multiple times
    @Test
    public void numberOfOpenSitesTest3() {
        Percolation p = new Percolation(3);
        p.open(1,1);
        p.open(1, 1);
        assertEquals(1, p.numberOfOpenSites());
    }

    //system does not percolate
    @Test
    public void percolatesTest1() {
        Percolation p = new Percolation(3);
        assertFalse(p.percolates());
    }

    //n=1 but system does not percolate
    @Test
    public void percolatesTest2() {
        Percolation p = new Percolation(1);
        assertFalse(p.percolates());
    }

    //System percolates
    @Test
    public void percolatesTest3() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        p.open(2, 1);
        p.open(2, 2);
        p.open(3, 2);
        assertTrue(p.percolates());
    }

}

 */