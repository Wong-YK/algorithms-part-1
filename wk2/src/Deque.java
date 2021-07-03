import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {

        Item item;
        Node llink;
        Node rlink;

    }

    private Node front;
    private Node rear;
    private int size;

    // construct an empty deque
    public Deque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node();
        newNode.item = item;
        if (this.isEmpty()) {
            newNode.rlink = null;
            newNode.llink = null;
            this.rear = newNode;
        }
        else {
            newNode.rlink = this.front;
            newNode.llink = null;
            this.front.llink = newNode;
        }
        this.front = newNode;
        this.size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node();
        newNode.item = item;
        if (this.isEmpty()) {
            newNode.rlink = null;
            newNode.llink = null;
            this.front = newNode;
        }
        else {
            newNode.rlink = null;
            newNode.llink = this.rear;
            this.rear.rlink = newNode;
        }
        this.rear = newNode;
        this.size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result = this.front.item;
        this.front = this.front.rlink;
        this.size--;
        if (this.size > 0) {
            this.front.llink = null;
        }
        return result;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result = this.rear.item;
        this.rear = this.rear.llink;
        this.size--;
        if (this.size > 0) {
            this.rear.rlink = null;
        }
        return result;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = front;

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        // not supported
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.rlink;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        System.out.println(d.isEmpty());
        System.out.println(d.size());
        for (int i = 1; i < 6; i++) {
            d.addFirst(i);
            d.addLast(10 - i);
        }
        System.out.println(d.size());
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d.size());
        for (int i: d) {
            System.out.print(i + " ");
        }
    }

}