
public class MaxHeap<E extends Comparable<E>> {

    private E[] Heap;
    private int size;
    private int n;

    public MaxHeap(E[] h, int num, int max) {
        Heap = h;
        n = num;
        size = max;
        buildheap();
    }

    // Return current number of elements
    public int heapsize() {
        return n;
    }

    // Check whether a position is a leaf
    public boolean isLeaf(int pos) {
        return (pos >= n / 2) && (pos < n);
    }

    // Return left child position
    public int leftchild(int pos) {
        if (pos >= n / 2) {
            throw new IllegalArgumentException("No left child");
        }
        return 2 * pos + 1;
    }

    // Return right child position
    public int rightchild(int pos) {
        if (pos >= (n - 1) / 2) {
            throw new IllegalArgumentException("No right child");
        }
        return 2 * pos + 2;
    }

    // Return parent position
    public int parent(int pos) {
        if (pos <= 0 || pos >= n) {
            throw new IllegalArgumentException("Position has no parent");
        }
        return (pos - 1) / 2;
    }

    // Build heap from existing array
    public void buildheap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    // Restore Max Heap property
    private void siftDown(int pos) {

        if (pos < 0 || pos >= n) {
            throw new IllegalArgumentException("Illegal heap position");
        }

        while (!isLeaf(pos)) {

            int j = leftchild(pos);

            if ((j < n - 1)
                    && (Heap[j].compareTo(Heap[j + 1]) < 0)) {
                j++;
            }

            if (Heap[pos].compareTo(Heap[j]) >= 0) {
                return;
            }

            swap(pos, j);
            pos = j;
        }
    }

    // Swap two elements
    private void swap(int pos1, int pos2) {
        E temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }

    // Insert a new element
    public void insert(E element) {

        if (n >= size) {
            throw new IllegalStateException("Heap is full");
        }

        int curr = n;
        Heap[curr] = element;
        n++;

        // Move element upwards
        while (curr > 0
                && Heap[curr].compareTo(Heap[parent(curr)]) > 0) {

            int p = parent(curr);
            swap(curr, p);
            curr = p;
        }
    }

    // Remove and return the root
    public E removeMax() {

        if (n == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        E max = Heap[0];

        swap(0, n - 1);
        n--;

        if (n > 0) {
            siftDown(0);
        }

        return max;
    }

    // Print first count elements of the heap array
    public void print(int count) {

        if (count < 0 || count > n) {
            throw new IllegalArgumentException("Invalid print count");
        }

        for (int i = 0; i < count; i++) {
            System.out.println(Heap[i]);
        }
    }
}
