import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A generic double-linked list implementation.
 * 
 * @param <T> the type of elements in this list
 * @author Jessica Park
 */

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int size;

    /**
     * A node in the double-linked list
     */
    protected class Node {
        T data;
        Node prev;
        Node next;

        /**
         * Constructs a new node with given data
         * 
         * @param data
         */
        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * iterator for the double-linked list
     */
    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current;
        
        /**
         * constructs a new iterator starting at the head of the list
         */
        public DoubleLinkedListIterator() {
            this.current = head;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
        @Override
        public boolean hasPrevious() {
            return current != null && current.prev != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = current.prev;
            return current.data;
        }
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }
        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * constructs an empty double-linked list
     */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * adds an element to the end of the list
     * 
     * @param data
     */
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * adds an element to the front of the list
     * 
     * @param data
     */
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * converts the list into an ArrayList
     * 
     * @return an ArrayList containing all elements in the list
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while(current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

}
