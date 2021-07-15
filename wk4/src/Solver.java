import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;
import java.util.Iterator;

public class Solver {

    private SearchNode finalNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        int n = initial.dimension();
        int[][] tiles = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == n - 1 && col == n - 1) {
                    tiles[row][col] = 0;
                }
                else {
                    tiles[row][col] = (row * n) + col + 1;
                }
            }
        }
        Board solved = new Board(tiles);
        SearchNode current = new SearchNode(initial, 0, null);
        SearchNode currentTwin = new SearchNode(initial.twin(), 0, null);
        MinPQ<SearchNode> mpq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> mpqTwin = new MinPQ<SearchNode>();
        mpq.insert(current);
        current = mpq.delMin();
        mpqTwin.insert(currentTwin);
        currentTwin = mpqTwin.delMin();
        while (!(current.getBoard().equals(solved) || currentTwin.getBoard().equals(solved))) {
            Iterable<Board> neighbours = current.getBoard().neighbors();
            Iterable<Board> neighboursTwin = currentTwin.getBoard().neighbors();
            for (Board neighbour: neighbours) {
                // critical optimization
                SearchNode previous = current;
                boolean useless = false;
                while (previous != null) {
                    if (previous.board.equals(neighbour)) {
                        useless = true;
                        break;
                    }
                    previous = previous.prevNode;
                }
                if (!useless) {
                    SearchNode newSN = new SearchNode(neighbour, current.getMoves() + 1, current);
                    mpq.insert(newSN);
                }
            }
            current = mpq.delMin();
        }
        this.finalNode = current;
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return this.finalNode.getMoves();
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return new Solution();
    }

    public static boolean inMPQ(Board b, MinPQ<SearchNode> mpq) {
        for (SearchNode searchNode: mpq) {
            if (searchNode.board.equals(b)) {
                return true;
            }
        }
        return false;
    }

    private static class SearchNode implements Comparable<SearchNode> {

        private final Board board;
        private final int moves;
        private final SearchNode prevNode;
        private final int hammingDistance;
        private final int manhattanDistance;

        SearchNode(Board board, int moves, SearchNode prevNode) {
            this.board = board;
            this.moves = moves;
            this.prevNode = prevNode;
            this.hammingDistance = board.hamming();
            this.manhattanDistance = board.manhattan();
        }

        public Board getBoard() {
            return this.board;
        }

        public int getMoves() {
            return this.moves;
        }

        public SearchNode getPrevNode() {
            return this.prevNode;
        }

        public int compareTo(SearchNode that) {
            return (this.hammingDistance + this.moves) - (that.hammingDistance + that.moves);
        }

        public Comparator<SearchNode> manhattanOrder() {
            return new ByManhattan();
        }

        private class ByManhattan implements Comparator<SearchNode> {

            public int compare(SearchNode sn1, SearchNode sn2) {
                return (sn1.manhattanDistance + sn1.moves) - (sn2.manhattanDistance + sn2.moves);
            }
        }
    }

    private class Solution implements Iterable<Board> {

        public Iterator<Board> iterator() { return new SolutionIterator(); }

        private class SolutionIterator implements Iterator<Board> {

            private SearchNode sn;

            SolutionIterator() {
                this.sn = null;
            }

            public boolean hasNext() {
                return sn != finalNode;
            }

            public void remove() {/* not supported */}

            public Board next() {
                SearchNode next = finalNode;
                while (next.prevNode != this.sn) {
                    next = next.prevNode;
                }
                this.sn = next;
                return sn.getBoard();
            }
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        MinPQ<SearchNode> mpq = new MinPQ<SearchNode>();
        Board b = new Board(new int[][] {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}});
        SearchNode sn = new SearchNode(b, 0, null);
        mpq.insert(sn);
        System.out.println(inMPQ(b, mpq));
    }

}
