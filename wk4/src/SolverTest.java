import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolverTest {

    /*

    Tests written to pass when SearchNode was taken outside of Solver class

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

}
