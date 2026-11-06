
public interface Queue<E> {

    /**
     * Reinitialize the queue. The user is responsible for reclaiming the
     * storage used by the queue elements.
     */
    public void clear();

    /**
     * Place an element at the rear of the queue.
     *
     * 
     */
    public void enqueue(E element);

    /**
     * Remove and return element at the front of the queue.
     *
     * 
     */
    public E dequeue();

    /**
     * return The number of elements in the queue.
     */
    public int length();
}
