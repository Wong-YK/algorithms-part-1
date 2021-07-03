import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int n;
    private int openSites;
    private int[][] grid;
    private WeightedQuickUnionUF wquf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.openSites = 0;
        this.grid = new int[n][n];
        this.wquf = new WeightedQuickUnionUF((n * n) + 2);
        for (int i = 1, j = n * n; i <= n; i++, j--) {
            this.wquf.union(0, i);
            this.wquf.union((n * n) + 1, j);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > this.n || col < 1 || col > this.n) {
            throw new IllegalArgumentException();
        }
        if (this.isOpen(row, col)) return;
        this.openSites++;
        int gridRow = row - 1;
        int gridCol = col - 1;
        int i = (((row - 1) * n) + col);
        this.grid[gridRow][gridCol] = i;
        if (gridRow < n - 1) {
            if (isOpen(row + 1, col)) wquf.union(i, this.grid[gridRow + 1][gridCol]);
        }
        if (gridRow > 0) {
            if (isOpen(row - 1, col)) wquf.union(i, this.grid[gridRow - 1][gridCol]);
        }
        if (gridCol < n - 1) {
            if (isOpen(row, col + 1)) wquf.union(i, this.grid[gridRow][gridCol + 1]);
        }
        if (gridCol > 0) {
            if (isOpen(row, col - 1)) wquf.union(i, this.grid[gridRow][gridCol - 1]);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > this.n || col < 1 || col > this.n) {
            throw new IllegalArgumentException();
        }
        return this.grid[row - 1][col - 1] != 0;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > this.n || col < 1 || col > this.n) {
            throw new IllegalArgumentException();
        }
        return this.isOpen(row, col) && this.wquf.find(0) == this.wquf.find(((row - 1) * n) + col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return this.wquf.find(0) == this.wquf.find((n * n) + 1) &&
                this.openSites > 0;
    }

    // test client (optional)
    public static void main(String[] args) {
        //Percolation grid = new Percolation(5);
        System.out.println("Hello world");
    }

}
