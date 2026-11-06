public class ArrayQueue<E> implements Queue<E>{
    private static final int DEFAULT_SIZE = 10;
    private int maxSize;
    private int front;
    private int rear;
    private int count;
    private E[] array;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int size) {
        this.maxSize = size;
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.array = (E[]) new Object[size];
    }

    @Override
    public void clear() {
        front = rear = count = 0;
    }

    @Override
    public void enqueue(E element) {
        if (count == maxSize) {
            doubleCapacity();
        }
        array[rear] = element;
        rear = (rear + 1) % maxSize;
        count++;
    }

    private void doubleCapacity() {
        int newSize = maxSize * 2;
        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[(front + i) % maxSize];
        }
        array = newArray;
        front = 0;
        rear = count;
        maxSize = newSize;
    }

    @Override
    public E dequeue() {
        assert count > 0 : "Queue is empty";
        E item = array[front];
        front = (front + 1) % maxSize;
        count--;
        return item;
    }

    @Override
    public int length() {
        return count;
    }
}