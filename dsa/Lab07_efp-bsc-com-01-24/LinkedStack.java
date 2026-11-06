public class LinkedStack<E> implements Stack<E> {
    private LinkNode<E> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public void push(E element) {
        top = new LinkNode<>(element, top,null);
    }

    @Override
    public E pop() {
        assert !isEmpty() : "Stack empty";
        E element = top.element();
        LinkNode<E> temp = top;
        top = top.next();
        temp.setNext(null);
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}