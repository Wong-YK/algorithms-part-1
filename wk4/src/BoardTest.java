import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    // 2 by 2 board
    public void toStringTest1() {
        int[][] tiles = {{0, 1}, {2, 3}};
        Board b = new Board(tiles);
        String expected = "2\n 0 1\n 2 3";
        assertTrue(b.toString().equals(expected));
    }


    @Test
    // 5 by 5 board
    public void toStringTest2() {
        int[][] tiles = {{1, 4, 5, 6, 8},
                {0, 2, 3, 9, 7},
                {10, 15, 16, 20, 24},
                {23, 22, 12, 18, 19},
                {11, 13, 21, 17, 14}};
        Board b = new Board(tiles);
        String expected = "5\n" +
                " 1 4 5 6 8\n" +
                " 0 2 3 9 7\n" +
                " 10 15 16 20 24\n" +
                " 23 22 12 18 19\n" +
                " 11 13 21 17 14";
        assertTrue(b.toString().equals(expected));
    }

    @Test
    // all tiles in correct place on a 2 by 2 board
    public void hammingTest1() {
        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        assertEquals(0, b.hamming());
    }

    @Test
    // 2 tiles out of place on a 2 by 2 board
    public void hammingTest2() {
        Board b = new Board(new int[][] {{0, 2}, {3, 1}});
        assertEquals(2, b.hamming());
    }

    @Test
    // 4 tiles out of place on a 2 by 2 board
    public void hammingTest3() {
        Board b = new Board(new int[][] {{0, 3}, {2, 1}});
        assertEquals(4, b.hamming());
    }

    @Test
    // 6 tiles out of place on a 5 by 5 board
    public void hammingTest4() {
        Board b = new Board(new int[][] {{8, 2, 3, 4, 5},
                {6, 7, 1, 9, 10},
                {11, 12, 15, 14, 13},
                {16, 17, 18, 0, 20},
                {21, 22, 23, 24, 19}});
        assertEquals(6, b.hamming());
    }

    /*
    @Test
    // tile in correct place in 2 by 2 board
    public void individualManhattanTest1() {
        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        assertEquals(0, b.individualManhattan(1, 0));
    }

    @Test
    // 0 tile in correct place in 2 by 2 board
    public void individualManhattanTest2() {
        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        assertEquals(0, b.individualManhattan(1, 1));
    }

    @Test
    // tile out of place by two vertical steps
    public void individualManhattanTest3() {
        Board b = new Board(new int[][] {{1, 2, 0}, {4, 5, 6}, {7, 8, 3}});
        assertEquals(2, b.individualManhattan(0, 2));
    }

    @Test
    // tile out of place by two horizontal steps
    public void individualManhattanTest4() {
        Board b = new Board(new int[][] {{1, 2, 3}, {6, 5, 4}, {7, 8, 0}});
        assertEquals(2, b.individualManhattan(1, 0));
    }

    @Test
    // tile out of place by two horizontal and two vertical steps
    public void individualManhattanTest5() {
        Board b = new Board(new int[][] {{1, 2, 7}, {4, 5, 6}, {3, 8, 0}});
        assertEquals(4, b.individualManhattan(0, 2));
    }
    */

    @Test
    // tiles all in place
    public void manhattanTest1() {
        Board b = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(0, b.manhattan());
    }

    @Test
    // two tiles out of place, each with a total manhattan distance of 2
    public void manhattanTest2() {
        Board b = new Board(new int[][] {{2, 1, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(2, b.manhattan());
    }

    @Test
    // 4 tiles out of place with a total manhattan distance of 6
    public void manhattanTest3() {
        Board b = new Board(new int[][] {{1, 5, 3}, {8, 2, 6}, {7, 4, 0}});
        assertEquals(6, b.manhattan());
    }

    @Test
    // 5 tiles out of place with a total manhattan distance of 8
    public void manhattanTest4() {
        Board b = new Board(new int[][] {{1, 3, 5}, {8, 2, 6}, {7, 4, 0}});
        assertEquals(8, b.manhattan());
    }

    @Test
    // boards are equal
    public void equalsTest1() {
        Board b1 = new Board(new int[][] {{1, 3, 5}, {8, 2, 6}, {7, 4, 0}});
        Board b2 = new Board(new int[][] {{1, 3, 5}, {8, 2, 6}, {7, 4, 0}});
        assertTrue(b1.equals(b2));
    }

    @Test
    // boards are of same dimension but not equal
    public void equalsTest2() {
        Board b1 = new Board(new int[][] {{1, 5, 3}, {8, 2, 6}, {7, 4, 0}});
        Board b2 = new Board(new int[][] {{1, 3, 5}, {8, 2, 6}, {7, 4, 0}});
        assertFalse(b1.equals(b2));
    }

    @Test
    // boards are of different dimensions
    public void equalsTest3() {
        Board b1 = new Board(new int[][] {{1, 5, 3}, {8, 2, 6}, {7, 4, 0}});
        Board b2 = new Board(new int[][] {{1, 3}, {2, 0}});
        assertFalse(b1.equals(b2));
    }

    @Test
    // object is not a board
    public void equalsTest4() {
        Board b1 = new Board(new int[][] {{1, 5, 3}, {8, 2, 6}, {7, 4, 0}});
        int b2 = 0;
        assertFalse(b1.equals(b2));
    }

    /*

    @Test
    // 4 neighbours
    public void NeighbourIteratorTest1() {
        Board b = new Board(new int[][]{{1, 2, 3}, {4, 0, 5}, {6, 7, 8}});
        Board n1 = new Board(new int[][]{{1, 2, 3}, {4, 7, 5}, {6, 0, 8}});
        Board n2 = new Board(new int[][]{{1, 0, 3}, {4, 2, 5}, {6, 7, 8}});
        Board n3 = new Board(new int[][]{{1, 2, 3}, {4, 5, 0}, {6, 7, 8}});
        Board n4 = new Board(new int[][]{{1, 2, 3}, {0, 4, 5}, {6, 7, 8}});
        Board[] neighbours = {n1, n2, n3, n4};
        int index = 0;
        for (Board neighbour : b.neighbors()) {
            //System.out.println(neighbour);
            assertTrue(neighbour.equals(neighbours[index++]));
        }
    }

        @Test
        // 3 neighbours
        public void NeighbourIteratorTest2() {
            Board b = new Board(new int[][]{{1, 0, 2}, {3, 4, 5}, {6, 7, 8}});
            Board n1 = new Board(new int[][]{{1, 4, 2}, {3, 0, 5}, {6, 7, 8}});
            Board n2 = new Board(new int[][]{{1, 2, 0}, {3, 4, 5}, {6, 7, 8}});
            Board n3 = new Board(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
            Board[] neighbours = {n1, n2, n3};
            int index = 0;
            for (Board neighbour : b.neighbors()) {
                //System.out.println(neighbour);
                assertTrue(neighbour.equals(neighbours[index++]));
            }
        }

    @Test
    // 2 neighbours
    public void NeighbourIteratorTest3() {
        Board b = new Board(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        Board n1 = new Board(new int[][]{{3, 1, 2}, {0, 4, 5}, {6, 7, 8}});
        Board n2 = new Board(new int[][]{{1, 0, 2}, {3, 4, 5}, {6, 7, 8}});
        Board[] neighbours = {n1, n2};
        int index = 0;
        for (Board neighbour : b.neighbors()) {
            //System.out.println(neighbour);
            assertTrue(neighbour.equals(neighbours[index++]));
        }
    }

    */


}
