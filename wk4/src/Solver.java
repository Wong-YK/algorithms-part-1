import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

public class Solver {

    class SearchNode implements Comparable<SearchNode> {

        private final Board board;
        private final int moves;
        private final SearchNode prevNode;

        SearchNode(Board board, int moves, SearchNode prevNode) {
            this.board = board;
            this.moves = moves;
            this.prevNode = prevNode;
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

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }


    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return null;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

}
