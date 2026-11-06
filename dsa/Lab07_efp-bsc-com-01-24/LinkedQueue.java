public class LinkedQueue<E> implements Queue<E> {
    private LinkNode<E> front;
    private LinkNode<E> rear;
    private int size;

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    public LinkedQueue(int initialCapacity) {
        front = rear = null;
        size = 0;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        LinkNode<E> newNode = new LinkNode<E>(element, null, rear);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        assert !isEmpty() : "Queue empty";
        E item = (E) front.element();
        front = front.next();
        if (front == null) {
            rear = null;
        } else {
            front.setPrev(null);
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