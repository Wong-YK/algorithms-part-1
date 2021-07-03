import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String result = "";
        float i = 1.0f;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            boolean replace = StdRandom.bernoulli(1/i);
            if (replace) {
                result = word;
            }
            i++;
        }
        StdOut.println(result);
    }
}