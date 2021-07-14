import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolverTest {

    /*

    Tests written to pass when SearchNode taken outside of Solver class

    @Test
    // Hamming distance of s2 < s1
    public void compareToTest1() {
        Board b1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b2 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        SearchNode s1 = new SearchNode(b2, 0, null);
        SearchNode s2 = new SearchNode(b1, 1, s1);
        assertTrue(s2.compareTo(s1) < 0);
    }

    @Test
    // Hamming distance of s1 = s2
    public void compareToTest2() {
        Board b1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        SearchNode s1 = new SearchNode(b1, 0, null);
        SearchNode s2 = new SearchNode(b1, 0, null);
        assertTrue(s2.compareTo(s1) == 0);
    }

    @Test
    // Hamming distance of s1 < s2
    public void compareToTest3() {
        Board b1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b2 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        SearchNode s1 = new SearchNode(b2, 0, null);
        SearchNode s2 = new SearchNode(b1, 1, s1);
        assertTrue(s1.compareTo(s2) > 0);
    }

    @Test
    // hamming distance equal but manhattan distance different
    public void compareTest1() {
        Board b1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b2 = new Board(new int[][] {{0, 2, 3}, {4, 5, 6}, {7, 8, 1}});
        SearchNode s1 = new SearchNode(b1, 2, null);
        SearchNode s2 = new SearchNode(b2, 0, null);
        SearchNode[] a = {s2, s1};
        Arrays.sort(a, s2.manhattanOrder());
        // System.out.println(a[0]);
        assertTrue(a[0] == s1);
    }

    @Test
    // Hamming and manhattan distance of b1 less than b2
    public void compareTest2() {
        Board b1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b2 = new Board(new int[][] {{0, 2, 3}, {4, 5, 6}, {7, 8, 1}});
        SearchNode s1 = new SearchNode(b1, 0, null);
        SearchNode s2 = new SearchNode(b2, 0, null);
        SearchNode[] a = {s2, s1};
        Arrays.sort(a, s2.manhattanOrder());
        // System.out.println(a[0]);
        assertTrue(a[0] == s1);
    }
    */

    @Test
    // n = 2 board solved in 0 moves
    public void movesTest1() {
        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        Solver s = new Solver(b);
        assertEquals(0, s.moves());
    }

    @Test
    // n = 2 board solved in 1 move
    public void movesTest2() {
        Board b = new Board(new int[][] {{1, 2}, {0, 3}});
        Solver s = new Solver(b);
        assertEquals(1, s.moves());
    }

    @Test
    // n = 2 board solved in 3 moves
    public void movesTest3() {
        Board b = new Board(new int[][] {{2, 0}, {1, 3}});
        Solver s = new Solver(b);
        assertEquals(3, s.moves());
    }

    @Test
    // n = 4 board solved in 6 moves
    public void movesTest4() {
        Board b = new Board(new int[][] {{0, 1, 2, 4}, {5, 6, 3, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}});
        Solver s = new Solver(b);
        assertEquals(6, s.moves());
    }

    @Test
    // n = 2 board solved in 1 move
    public void solutionTest1() {
        Board initial = new Board(new int[][] {{1, 2}, {0, 3}});
        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        Board[] expected = {initial, b};
        Solver solver = new Solver(initial);
        Iterable<Board> solution = solver.solution();
        int index = 0;
        for (Board board: solution) {
            //assertTrue(board.equals(expected[index++]));
            assertEquals(expected[index++], board);
        }
    }

    @Test
    // n = 2 board solved in 3 moves
    public void solutionTest2() {
        Board b1 = new Board(new int[][] {{2, 0}, {1, 3}});
        Board b2 = new Board(new int[][] {{0, 2}, {1, 3}});
        Board b3 = new Board(new int[][] {{1, 2}, {0, 3}});
        Board b4 = new Board(new int[][] {{1, 2}, {3, 0}});
        Board[] expected = {b1, b2, b3, b4};
        Solver solver = new Solver(b1);
        Iterable<Board> solution = solver.solution();
        int index = 0;
        for (Board board: solution) {
            assertEquals(expected[index++], board);
        }
    }

}
