import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Iterator;

public class Solver {

    private SearchNode finalNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        SearchNode current = new SearchNode(initial, 0, null);
        SearchNode currentTwin = new SearchNode(initial.twin(), 0, null);
        MinPQ<SearchNode> mpq = new MinPQ<SearchNode>(current.manhattanOrder());
        MinPQ<SearchNode> mpqTwin = new MinPQ<SearchNode>(currentTwin.manhattanOrder());
        mpq.insert(current);
        current = mpq.delMin();
        mpqTwin.insert(currentTwin);
        currentTwin = mpqTwin.delMin();
        while (!(current.board.isGoal() || currentTwin.board.isGoal())) {
            Iterable<Board> neighbours = current.board.neighbors();
            Iterable<Board> neighboursTwin = currentTwin.board.neighbors();
            for (Board neighbour: neighbours) {
                if (!isInserted(neighbour, current)) {
                    SearchNode newSN = new SearchNode(neighbour, current.moves + 1, current);
                    mpq.insert(newSN);
                }
            }
            for (Board neighbourTwin: neighboursTwin) {
                if (!isInserted(neighbourTwin, currentTwin)) {
                    SearchNode newSN = new SearchNode(neighbourTwin, currentTwin.moves + 1, currentTwin);
                    mpqTwin.insert(newSN);
                }
            }
            current = mpq.delMin();
            currentTwin = mpqTwin.delMin();
        }
        if (currentTwin.manhattanDistance == 0) {
            this.finalNode = null;
        }
        else {
            this.finalNode = current;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return this.finalNode != null;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (this.finalNode == null) {
            return -1;
        }
        return this.finalNode.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (this.finalNode == null) {
            return null;
        }
        return new Solution();
    }

    private static boolean isInserted(Board b1, SearchNode current) {
        SearchNode previous = current.prevNode;
        if (previous == null) {
            return false;
        }
        Board b2 = previous.board;
        return b1.equals(b2);
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
                return sn.board;
            }
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        Board b = new Board(new int[][] {{5, 1, 8}, {2, 7, 3}, {4, 0, 6}});
        //Board b = new Board(new int[][] {{7, 8, 5}, {4, 0, 2}, {3, 6, 1}});
        Solver s = new Solver(b);
        System.out.println(s.moves());
        /*
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    */
    }

}
