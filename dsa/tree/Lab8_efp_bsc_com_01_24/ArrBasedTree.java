
public class ArrBasedTree {

    private int[] arr;
    private int n;

    public ArrBasedTree(int capacity) {// Constructor
        arr = new int[capacity];
        n = 0;
    }

    public void insert(int value) {// Insert
        if (n == arr.length) {
            System.out.println("Sorry, The tree is full :(");
            return;
        }

        arr[n] = value;
        n++;
    }

    public int get(int r) {// getter 
        if (r < 0 || r >= n) {
            return -1;
        }

        return arr[r];
    }

    public int parent(int r) {// find parent
        if (r <= 0 || r >= n) {
            return -1;
        }

        return (r - 1) / 2;
    }

    
    public int leftChild(int r) {// find left child
                  if (r < 0 || r >= n) {
            return -1;
        }

        int left = 2 * r + 1;

        if (left < n) {
            return left;
        }

        return -1;
    }

    
    public int rightChild(int r) {// find right child
        if (r < 0 || r >= n) {
            return -1;
        }

        int right = 2 * r + 2;

        if (right < n) {
            return right;
        }

        return -1;
    }

    
    public int leftSibling(int r) {// find left sibling
        if (r <= 0 || r >= n || r % 2 != 0) {
            return -1;
        }

        return r - 1;
    }

    
    public int rightSibling(int r) {// find right sibling
        if (r < 0 || r >= n || r % 2 == 0) {
            return -1;
        }

        if (r + 1 < n) {
            return r + 1;
        }

        return -1;
    }

    
    public boolean isLeaf(int r) {// check whether node is a leaf
        if (r < 0 || r >= n) {
            return false;
        }

        return r >= n / 2;
    }

    
    public void printt() {// print tree
        for (int i = 0; i < n; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }

    
    public int size() {// Return number of nodes
        return n;
    }

    
    public static void main(String[] args) {

        ArrBasedTree bt = new ArrBasedTree(10);

        bt.insert(10);
        bt.insert(11);
        bt.insert(12);
        bt.insert(40);
       

        bt.printt();

        int r = 1;

        System.out.println("\nCurrent node: " + bt.get(r));

        int p = bt.parent(r);
        int l = bt.leftChild(r);
        int right = bt.rightChild(r);

        System.out.println("Parent node: " + (p == -1 ? "None" : bt.get(p)));

        System.out.println("Left child: " + (l == -1 ? "None" : bt.get(l)));

        System.out.println("Right child: " + (right == -1 ? "None" : bt.get(right)));

        System.out.println("leaf: " + bt.isLeaf(r));
    }
}
