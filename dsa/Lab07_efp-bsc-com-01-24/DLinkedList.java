
public class DLinkedList<E> implements List<E> {

    private LinkNode<E> head;
    private LinkNode<E> tail; 
    private LinkNode<E> curr; 
    private int count; 

    public DLinkedList() { // constructor
        count = 0;
        head = tail = curr = new LinkNode<E>(null,null,null);
    }
    @Override
    public void append(E item) {
        LinkNode<E> newNode = new LinkNode<>(item,null,tail);
        tail.setNext(newNode);
        tail = newNode;
        count++;
    }

    @Override
    public void clear() {
        count = 0;
        head = tail = curr;
        head.setNext(null); 
    }

    @Override
    public void setFirst() {
        curr = head; 
    }

    @Override
    public void next() {
        if (curr.next() != null) {
            curr = curr.next();
        }
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public void setPos(int pos) {
        assert pos >= 0 && pos < count : "invalid list position";
        curr = head; 
        for (int i = 1; i <= pos; i++) {
            curr = curr.next();
        }
    }
    @Override
    public void print() {
        LinkNode<E> temp = head.next();
        while (temp != null) {
            System.out.print(temp.element() + " ");
            temp = temp.next();
        }
        System.out.println();
    }

    @Override
    public void setValue(E val) {
        assert curr != null : "invalid list position";
        assert curr.next() != null : "invalid list position";
        curr.next().setElement(val);
    }

    @Override
    public E currValue() {
        assert curr != null : "invalid list position";
        assert curr.next() != null : "invalid list position";
        return (E) curr.next().element();
    }

    @Override
    public boolean isEmpty() {
        return head.next() == null;
    }

    @Override
    public boolean isInList() {
        return curr != null && !isEmpty();
    }

    @Override
    public void prev() {
        if (curr == null || curr == head) { 
            curr = null;
            return;
        }
        LinkNode<E> temp = head;
        while (temp != null && temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    @Override
    public void insert(E item) {
        assert curr != null : "invalid list position";
        count++; 
        LinkNode<E> newNode = new LinkNode<>(item, curr.next(),curr);
        curr.setNext(newNode);
        if (curr == tail) {
            tail = tail.next();
        }
    }

    @Override
    public E remove() {
        if (curr == null || isEmpty()) 
        {
            return null;
        }
        LinkNode<E> temp = curr.next();
        curr.setNext(temp.next());
        temp.setNext(null);
        count--; 
        if (temp == tail) 
        {
            tail = curr;
        }
        return temp.element();
    }
}
