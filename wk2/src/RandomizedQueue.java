import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int first;
    private int last;
    private int size;
    private int capacity;

    // construct an empty randomized queue
    public RandomizedQueue(){
        this.capacity = 1;
        this.size = 0;
        this.first = 0;
        this.last = 0;
        this.q =(Item[]) new Object[this.capacity];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if ( !this.isEmpty() && (this.first == (this.last + 1) % this.capacity || this.first == this.last)) {
            this.resize(capacity * 2);
        }
        this.last = (this.last + 1) % this.capacity;
        this.q[this.last] = item;
        this.size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result;
        int index;
        do {
            index = StdRandom.uniform(0, this.capacity);
            result = this.q[index];
        }
        while (result == null);
        this.q[index] = null;
        this.size--;
        if (this.size <= this.capacity/4 && this.size > 0) {
            this.resize(this.capacity/2);
        }
        return result;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result;
        int index;
        do {
            index = StdRandom.uniform(0, this.capacity);
            result = this.q[index];
        }
        while (result == null);
        return result;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] qCopy = intialiseQCopy();
        private Item[] items = initialiseItems();
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return this.currentIndex < size;
        }

        // not supported
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Item result = this.items[this.currentIndex++];
            return result;
        }

        private Item[] intialiseQCopy() {
            Item[] result = (Item[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                result[i] = q[i];
            }
            return result;
        }

        private Item[] initialiseItems() {
            Item[] result = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                int randIndex;
                do {
                    randIndex = StdRandom.uniform(0, capacity);
                }
                while (this.qCopy[randIndex] == null);
                result[i] = this.qCopy[randIndex];
                this.qCopy[randIndex] = null;
            }
            return result;
        }
    }

    // TODO sort out this method!
    private void resize(int newSize) {
        Item[] newQ = (Item[]) new Object[newSize];
        for (int i = 0, j = this.first; i < this.size; i++, j = (j + 1) % this.capacity) {
            while (this.q[j] == null) {
                j = (j + 1) % this.capacity;
            }
            newQ[i] = this.q[j];
        }
        this.first = 0;
        this.last = this.size() - 1;
        this.capacity = newSize;
        this.q = newQ;
    }

    // unit testing (required)
    public static void main(String[] args) {
        /*
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        System.out.println(rq.isEmpty());
        for (int i = 1; i < 10; i++) {
            rq.enqueue(i);
        }
        System.out.println(rq.isEmpty());
        System.out.println("Queue size: " + rq.size());
        for (int i = 0; i < 6; i++) {
            rq.dequeue();
        }
        System.out.println("Queue size: " + rq.size());
        System.out.print("Queue items: ");
        for (int i: rq) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Two random samples: " + rq.sample() + " " + rq.sample());
        for (int i = 0; i < 3; i++) {
            rq.dequeue();
        }
        */
    }

}