
public class LinkNode<E> { // dynamically linked node

    private E element;
    private LinkNode<E> next;
    private LinkNode<E> prev;

    public LinkNode(E elem, LinkNode<E> nxt, LinkNode<E> prv) { // Constructor
        element = elem;
        next = nxt;
        prev = prv;
    }
    public LinkNode (LinkNode nextnode){
        next = nextnode;
    }

    public LinkNode next() {
        return next;
    }

    public LinkNode prev() {
        return prev;
    }

    public E element() {
        return element;
    }

    public void setNext(LinkNode nxt) {
        next = nxt;
    }

    public void setPrev(LinkNode prv) {
        prev = prv;
    }

    public void setElement(E elem) {
        element = elem;
    }
}
