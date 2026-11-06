public class DDLinkedList<E> implements List<E> {
    private LinkNode<E> head;
    private LinkNode<E> tail;
    private LinkNode<E> curr;
    private int count;

    public DDLinkedList() {
        head = tail = curr = null;
        count = 0;
    }

    @Override
    public void clear() {
        head = tail = curr = null;
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
            head = tail = curr = new LinkNode<>(item, null, null);
        } else {
            assert curr != null : "Invalid position";
            LinkNode<E> newNode = new LinkNode<>(item, curr, curr.prev());
            if (curr.prev() != null) {
                curr.prev().setNext(newNode);
            } else {
                head = newNode;
            }
            curr.setPrev(newNode);
            curr = newNode;
        }
        count++;
    }

    @Override
    public void append(E item) {
        if (isEmpty()) {
            head = tail = curr = new LinkNode<>(item, null, null);
        } else {
            LinkNode<E> newNode = new LinkNode<>(item, null, tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    @Override
    public E remove() {
        if (isEmpty() || curr == null) return null;
        E item = curr.element();

        if (curr.prev() != null) {
            curr.prev().setNext(curr.next());
        } else {
            head = curr.next();
        }

        if (curr.next() != null) {
            curr.next().setPrev(curr.prev());
        } else {
            tail = curr.prev();
        }

        curr = (curr.next() != null) ? curr.next() : head;
        count--;
        return item;
    }

    @Override
    public void print() {
        LinkNode<E> temp = head;
        while (temp != null) {
            System.out.print(temp.element() + " ");
            temp = temp.next();
        }
        System.out.println();
    }
}