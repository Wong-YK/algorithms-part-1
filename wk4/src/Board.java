import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class Board {

    private final int[][] tiles;
    private final int n;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.tiles = tiles;
        this.n = tiles.length;
    }

    // string representation of this board
    public String toString() {
        String result = Integer.toString(this.n) + "\n";
        for (int row = 0; row < this.n; row++) {
            String rowString = " ";
            for (int col = 0; col < this.n; col++) {
                rowString += Integer.toString(this.tiles[row][col]);
                if (col < this.n - 1) {
                    rowString = rowString + " ";
                }
            }
            result += rowString;
            if (row < this.n - 1) {
                 result += "\n";
            }
        }
        return result;
    }

    // board dimension n
    public int dimension() {
        return this.n;
    }

    // number of tiles out of place
    public int hamming() {
        int result = 0;
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                int n = (row * this.n) + col + 1;
                if (n == this.n * this.n) {
                    n = 0;
                }
                if (this.tiles[row][col] != n) {
                    result++;
                }
            }
        }
        return result;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int result = 0;
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                result += this.individualManhattan(row, col);
            }
        }
        return result;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return this.manhattan() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (!(y instanceof Board)) {
            return false;
        }
        if (this.dimension() != ((Board) y).dimension()) {
            return false;
        }
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension(); col++) {
                if (this.tiles[row][col] != ((Board) y).tiles[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return new NeighbourIterable();
    }


    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int r1;
        int c1;
        int r2;
        int c2;
        do {
            r1 = StdRandom.uniform(this.n);
            c1 = StdRandom.uniform(this.n);
            r2 = StdRandom.uniform(this.n);
            c2 = StdRandom.uniform(this.n);
        }
        while (this.tiles[r1][c1] == 0 || this.tiles[r2][c2] == 0);
        int[][] t = deepCopy();
        swap(r1, c1, r2, c2, t);
        return new Board(t);
    }

    private int individualManhattan(int row, int col) {
        int num = this.tiles[row][col];
        int arrangedRow;
        int arrangedCol;
        if (num == 0) {
            arrangedRow = this.n - 1;
            arrangedCol = this.n - 1;
        }
        else {
            arrangedRow = (num - 1) / this.n;
            arrangedCol = (num - 1) % this.n;
        }
        return Math.abs(row - arrangedRow) + Math.abs(col - arrangedCol);
    }

    private class NeighbourIterable implements Iterable<Board> {

        private final Board[] neighbours;

        NeighbourIterable() {
            // find coordinates for 0 tile
            int zeroRow = -1;
            int zeroCol = -1;
            for (int row = 0; row < dimension(); row++) {
                for (int col = 0; col < dimension(); col++) {
                    if (tiles[row][col] == 0) {
                        zeroRow = row;
                        zeroCol = col;
                        break;
                    }
                }
                if (zeroRow >= 0) break;
            }
            // generate adjacent coordinates
            ArrayList<int[]> adjCoords = new ArrayList<int[]>();
            int[] adj1 = {zeroRow + 1, zeroCol};
            if (adj1[0] < n) {
                adjCoords.add(adj1);
            }
            int[] adj2 = {zeroRow - 1, zeroCol};
            if (adj2[0] >= 0) {
                adjCoords.add(adj2);
            }
            int[] adj3 = {zeroRow, zeroCol + 1};
            if (adj3[1] < n) {
                adjCoords.add(adj3);
            }
            int[] adj4 = {zeroRow, zeroCol - 1};
            if (adj4[1] >= 0) {
                adjCoords.add(adj4);
            }
            // generate array of neighbours
            Board[] neighbours = new Board[adjCoords.size()];
            for (int i = 0; i < adjCoords.size(); i++) {
                int[][] neighbourTiles = deepCopy();
                swap(zeroRow, zeroCol, adjCoords.get(i)[0], adjCoords.get(i)[1], neighbourTiles);
                Board b = new Board(neighbourTiles);
                neighbours[i] = b;
            }
            this.neighbours = neighbours;
        }

        public Iterator<Board> iterator() {
            return new NeighbourIterator();
        }

        private class NeighbourIterator implements Iterator<Board> {

            private int i = -1;

            public boolean hasNext() {
                return i < neighbours.length - 1;
            }

            public void remove() {/* not supported */}

            public Board next() {
                return neighbours[++i];
            }

        }
    }

    private int[][] deepCopy() {
        int[][] result = new int[this.n][this.n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = tiles[row][col];
            }
        }
        return result;
    }

    private void swap(int r1, int c1, int r2, int c2,  int[][] t) {
        int temp = t[r1][c1];
        t[r1][c1] = t[r2][c2];
        t[r2][c2] = temp;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }
}
