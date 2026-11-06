public class ArrayStack<E> implements Stack<E>{
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private int top;
    private E[] array;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int size) {
        this.size = size;
        this.top = 0;
        this.array = (E[]) new Object[size];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public void push(E element) {
        if (top == size) {
            doubleCapacity();
        }
        array[top++] = element;
    }

    private void doubleCapacity() {
        int newSize = size * 2;
        E[] newArray = (E[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        size = newSize;
    }

    @Override
    public E pop() {
        assert !isEmpty() : "Stack empty";
        return array[--top];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
}