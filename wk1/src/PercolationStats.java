import edu.princeton.cs.algs4.StdRandom;
import java.lang.Math;

public class PercolationStats {

    private double[] thresholds;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.thresholds = new double[trials];
        for (int t = 0; t < trials; t++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                p.open(row, col);
            }
            double threshold = (double) p.numberOfOpenSites() / (n * n);
            this.thresholds[t] = threshold;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        double result = 0;
        for (double threshold: thresholds) {
            result += threshold;
        }
        result /= thresholds.length;
        return result;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double numerator = 0;
        for (double threshold: thresholds) {
            numerator += ((threshold - this.mean()) * (threshold - this.mean()));
        }
        double denominator = this.thresholds.length - 1;
        return Math.sqrt(numerator / denominator);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - ((1.96 * this.stddev()) / Math.sqrt(thresholds.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + ((1.96 * this.stddev()) / Math.sqrt(thresholds.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        //PercolationStats ps = new PercolationStats(Integer.parseInt("200"), Integer.parseInt("100"));
        System.out.println(String.format("mean                    = %f", ps.mean()));
        System.out.println(String.format("stddev                  = %f", ps.stddev()));
        System.out.println(String.format("95%% confidence interval = [%f, %f]", ps.confidenceLo(), ps.confidenceHi()));
    }

}
