import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class DutchNationalFlag {

    int n;
    char[] arr;
    char[] colours = {'r', 'w', 'b'};

    DutchNationalFlag(int n) {
        this.n = n;
        //this.n = 10;
        this.arr = new char[n];
        for (int i = 0; i < n; i++) {
            int j = StdRandom.uniform(0, 3);
            this.arr[i] = this.colours[j];
        }
    }

    public void swap(int i, int j) {
        char temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    public char colour(int i) {
        return this.arr[i];
    }

    public void sort() {
        char first = 'n';
        char last = arr[this.n - 1];

        int lo = 0;
        int hi = n - 2;

        for (int i = 0; i <= hi;) {
            char colour = colour(i);
            // initialising first
            if (first == 'n' && colour != last) {
                first = colour;
                i++;
                lo++;
            }
            else if (colour == first) {
                if (i != lo) {
                    this.swap(i, lo);
                    lo++;
                }
                else {
                    lo++;
                    i++;
                }
            }
            else if (colour == last) {
                if (i != hi) {
                    swap(i, hi);
                    hi--;
                }
            }
            else {
                i++;
            }
        }

    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < this.n; i++) {
            if (i == this.n - 1) {
                result = result + this.colour(i) + "]";
            }
            else {
                result = result + this.colour(i) + ", ";
            }
        }
        return result;
    }

    // TODO run tests with the following array: [r, w, r, b, w, w, r, w, r, w]
    public static void main(String[] args) {
        DutchNationalFlag dnf = new DutchNationalFlag(10);
        System.out.print("Unsorted: ");
        System.out.println(dnf);
        dnf.sort();
        System.out.print("Sorted: ");
        System.out.println(dnf);

    }




}
