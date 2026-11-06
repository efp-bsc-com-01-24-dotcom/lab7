
public interface Stack<E> {

    public void clear(); // Remove all elements from the stack

    public void push(E element); // Push onto stack

    public E pop(); // Pop an element from the top

    public boolean isEmpty(); // Check for stack emptiness
}
