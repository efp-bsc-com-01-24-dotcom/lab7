public class LinkedQueue2<E> implements Queue<E> {
    private LinkNode<E> head; 
    private LinkNode<E> tail; 
    private int size;

    public LinkedQueue2() {
        head = tail = null;
        size = 0;
    }

    public LinkedQueue2(int initialCapacity) {
        head = tail = null;
        size = 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        LinkNode<E> newNode = new LinkNode<E>(element, head, null);
        if (head != null) {
            head.setPrev(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    @Override
    public E dequeue() {
        assert !isEmpty() : "Queue empty";
        E item = (E) tail.element();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev();
            if (tail != null) {
                tail.setNext(null);
            }
        }
        size--;
        return item;
    }

    @Override
    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}