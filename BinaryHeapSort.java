public class BinaryHeapSort {
    private int[] arr; // Array to store the heap
    private int heapsize; // Current size of the heap

    // Constructor to initialize the heap with a given array
    public BinaryHeapSort(int[] input) {
        arr = new int[input.length + 1]; // Skip index 0 for easier calculations
        heapsize = input.length;

        // Copy input array into heap, starting at index 1
        for (int i = 0; i < input.length; i++) {
            arr[i + 1] = input[i];
        }
    }

    // Helper method to find the left child of a node
    private int left(int i) {
        return 2 * i;
    }

    // Helper method to find the right child of a node
    private int right(int i) {
        return 2 * i + 1;
    }

    // Helper method to maintain heap property
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int max = i;

        if (l <= heapsize && arr[l] > arr[i]) {
            max = l;
        }
        if (r <= heapsize && arr[r] > arr[max]) {
            max = r;
        }

        if (max != i) {
            // Swap values
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            // Recursively heapify the affected subtree
            heapify(max);
        }
    }

    // Build a heap from the array
    private void buildHeap() {
        for (int i = heapsize / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    // HeapSort method
    public void heapSort() {
        buildHeap(); // First, build the heap
        int h = heapsize;

        // Sort the array
        for (int i = h; i > 1; i--) {
            // Swap the largest element (root) with the last element in the heap
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;

            // Reduce heap size and heapify the root
            heapsize--;
            heapify(1);
        }

        // Restore heap size for consistent state
        heapsize = h;
    }

    // Display the sorted array
    public void displaySortedArray() {
        for (int i = 1; i <= heapsize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the heapSort() implementation
    public static void main(String[] args) {
        int[] input = {10, 5, 20, 2, 15};
        BinaryHeapSort heapSort = new BinaryHeapSort(input);

        System.out.println("Array before sorting:");
        heapSort.displaySortedArray();

        heapSort.heapSort(); // Perform sorting

        System.out.println("Array after sorting:");
        heapSort.displaySortedArray(); // Output should be in ascending order
    }
}
