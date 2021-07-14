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
        MinPQ<SearchNode> mpq = new MinPQ<SearchNode>();
        mpq.insert(current);
        current = mpq.delMin();
        while (!(current.getBoard().equals(solved))) {
            Iterable<Board> neighbours = current.getBoard().neighbors();
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

    private class SearchNode implements Comparable<SearchNode> {

        private final Board board;
        private final int moves;
        private final SearchNode prevNode;

        SearchNode(Board board, int moves, SearchNode prevNode) {
            this.board = board;
            this.moves = moves;
            this.prevNode = prevNode;
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
            return (this.board.hamming() + this.moves) - (that.board.hamming() + that.moves);
        }

        public Comparator<SearchNode> manhattanOrder() {
            return new ByManhattan();
        }

        private class ByManhattan implements Comparator<SearchNode> {

            public int compare(SearchNode sn1, SearchNode sn2) {
                return (sn1.board.manhattan() + sn1.moves) - (sn2.board.manhattan() + sn2.moves);
            }
        }
    }

    private class Solution implements Iterable<Board> {

        public Iterator<Board> iterator() { return new SolutionIterator(); }

        private class SolutionIterator implements Iterator<Board> {

            private SearchNode sn;

            SolutionIterator() {
                SearchNode initial = finalNode;
                while (initial.prevNode != null) {
                    initial = initial.prevNode;
                }
                this.sn = initial;
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
        Board b = new Board(new int[][] {{1, 2}, {0, 3}});
        Solver solver = new Solver(b);
        Iterable<Board> solution = solver.solution();
        for (Board board: solution) {
            System.out.println(board);
        }
    }

}
