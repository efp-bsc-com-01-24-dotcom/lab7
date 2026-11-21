
public class StudentHeap {

    public static void main(String[] args) {

        // Create an array with capacity for 100 students
        Student[] students = new Student[100];

        // Create an empty MaxHeap
        MaxHeap<Student> heap = new MaxHeap<>(students, 0, 100);

        // Insert 50 random students
        for (int i = 0; i < 50; i++) {
            heap.insert(new Student());
        }

        System.out.println("the first 50 elems: ");

        
        heap.print(50); // printint the heap 

        // Remove the root 49 times
        for (int i = 0; i < 49; i++) {
            heap.removeMax();
        }

        System.out.println("\nAFTER REMOVING ROOT 49 TIMES:");

        // Print the first 50 elements
        heap.print(1);
    }
}
