public class BinaryHeap {
    private int[] arr; // Array to store the heap
    private int heapsize; // Current size of the heap

    // Constructor to initialize the heap with a maximum size
    public BinaryHeap(int capacity) {
        arr = new int[capacity + 1]; // Skip index 0 for easier calculations
        heapsize = 0;
    }

    // Helper method to find the parent of a node
    private int parent(int i) {
        return i / 2;
    }

    // Helper method to insert a new element into the heap
    public void heapInsert(int k) {
        heapsize++; // Increase the size of the heap
        int i = heapsize;

        // Bubble up the element to maintain the heap property
        while (i > 1 && arr[parent(i)] > k) {
            arr[i] = arr[parent(i)]; // Move the parent value down
            i = parent(i); // Move to the parent's position
        }

        arr[i] = k; // Place the new element in its correct position
    }

    // Helper method to display the heap
    public void displayHeap() {
        for (int i = 1; i <= heapsize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the heapInsert method
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10); // Create a heap with capacity 10

        // Insert elements into the heap
        heap.heapInsert(10);
        heap.heapInsert(5);
        heap.heapInsert(20);
        heap.heapInsert(2);
        heap.heapInsert(15);

        // Display the heap after each insertion
        System.out.println("Heap after inserts:");
        heap.displayHeap(); // Should show elements in min-heap order
    }
}
