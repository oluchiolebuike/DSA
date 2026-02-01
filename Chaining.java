import java.util.LinkedList;

class Chaining {
    // Node class to represent key-value pairs
    private static class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table; // Array of linked lists
    private int size; // Size of the hash table

    // Constructor to initialize the hash table
    @SuppressWarnings("unchecked")
    public Chaining(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function: Compute index for a given key
    private int hashFunction(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c; // Simple sum of ASCII values
        }
        return hash % size;
    }

    // Insert operation
    public void insert(String key, String value) {
        int index = hashFunction(key);
        LinkedList<Node> chain = table[index];

        // Check if the key already exists, and update its value
        for (Node node : chain) {
            if (node.key.equals(key)) {
                node.value = value; // Update value for the existing key
                return;
            }
        }

        // Key does not exist, add new node
        chain.add(new Node(key, value));
    }

    // Lookup operation
    public String lookup(String key) {
        int index = hashFunction(key);
        LinkedList<Node> chain = table[index];

        // Traverse the chain to find the key
        for (Node node : chain) {
            if (node.key.equals(key)) {
                return node.value; // Return the value if key is found
            }
        }

        return "Not found"; // Key not found
    }

    // Example usage
    public static void main(String[] args) {
        Chaining hashTable = new Chaining(10);

        // Insert keys into the hash table
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");

        // Lookup keys
        System.out.println("Value for 'key1': " + hashTable.lookup("key1")); // Output: value1
        System.out.println("Value for 'key2': " + hashTable.lookup("key2")); // Output: value2
        System.out.println("Value for 'key4': " + hashTable.lookup("key4")); // Output: Not found
    }
}
