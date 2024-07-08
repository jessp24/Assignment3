import java.util.Comparator;

/**
 * a sorted double linked list implementation
 * 
 * @author Jessica Park
 * 
 * @param <T> the type of elements in this list
 * 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    /**
     * constructs an empty sorted double linked list with the specified comparator
     * 
     * @param comparator the comparator used to order the elements in the list
     */

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * adds an element to the list in sorted order
     * 
     * @param data the element to add
     */
    public void add(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current != null && comparator.compare(data, current.data) > 0) {
                current = current.next;
            }
            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException();
    }
}
