
public class CDLinkedList<E> implements List<E> {

    private LinkNode<E> head;
    private LinkNode<E> curr;
    private int count;

    public CDLinkedList() {
        head = curr = null;
        count = 0;
    }

    @Override
    public void clear() {
        head = curr = null;
        count = 0;
    }

    @Override
    public void setFirst() {
        curr = head;
    }

    @Override
    public void next() {
        if (curr != null) {
            curr = curr.next();
        }
    }

    @Override
    public void prev() {
        if (curr != null) {
            curr = curr.prev();
        }
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public void setPos(int pos) {
        assert pos >= 0 && pos < count : "Invalid position";
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
    }

    @Override
    public void setValue(E val) {
        assert curr != null : "Invalid position";
        curr.setElement(val);
    }

    @Override
    public E currValue() {
        assert curr != null : "Invalid position";
        return curr.element();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isInList() {
        return curr != null;
    }

    @Override
    public void insert(E item) {
        if (isEmpty()) {
            head = new LinkNode<>(item, null, null);
            head.setNext(head);
            head.setPrev(head);
            curr = head;
        } else {
            LinkNode<E> newNode = new LinkNode<>(item, curr, curr.prev());
            curr.prev().setNext(newNode);
            curr.setPrev(newNode);
            curr = newNode;
        }
        count++;
    }

    @Override
    public void append(E item) {
        if (isEmpty()) {
            insert(item);
        } else {
            LinkNode<E> tail = head.prev();
            LinkNode<E> newNode = new LinkNode<>(item, head, tail);
            tail.setNext(newNode);
            head.setPrev(newNode);
            count++;
        }
    }

    @Override
    public E remove() {
        if (isEmpty() || curr == null) {
            return null;
        }
        E item = curr.element();
        if (count == 1) {
            head = curr = null;
        } else {
            curr.prev().setNext(curr.next());
            curr.next().setPrev(curr.prev());
            if (curr == head) {
                head = curr.next();
            }
            curr = curr.next();
        }
        count--;
        return item;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        LinkNode<E> temp = head;
        for (int i = 0; i < count; i++) {
            System.out.print(temp.element() + " ");
            temp = temp.next();
        }
        System.out.println();
    }
}
