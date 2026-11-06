public class NLinkedStack<E> implements Stack<E> {
    private LinkNode<E> head;
    private LinkNode<E> top;

    public NLinkedStack() {
        head = top = null;
    }

    @Override
    public void clear() {
        head = top = null;
    }

    @Override
    public void push(E element) {
        LinkNode<E> newNode = new LinkNode<>(element, null,top);
        if (isEmpty()) {
            head = top = newNode;
        } else {
            top.setNext(newNode);
            top = newNode;
        }
    }

    @Override
    public E pop() {
        assert !isEmpty() : "Stack empty";
        E item = top.element();
        if (head == top) {
            head = top = null;
        } else {
            LinkNode<E> temp = head;
            while (temp.next() != top) {
                temp = temp.next();
            }
            temp.setNext(null);
            top = temp;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}