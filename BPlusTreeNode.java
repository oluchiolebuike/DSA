public class BTreeLookup {
    static class Node {
        boolean isLeaf;
        int[] keys;
        Node[] children;
        String[] values; // Only for leaf nodes

        Node(boolean isLeaf, int maxKeys) {
            this.isLeaf = isLeaf;
            this.keys = new int[maxKeys];
            this.children = isLeaf ? null : new Node[maxKeys + 1];
            this.values = isLeaf ? new String[maxKeys] : null;
        }
    }

    public static String lookup(Node root, int key) {
        Node current = root;

        while (!current.isLeaf) {
            int j = 0;

            // Find smallest key Kj greater than the input key
            while (j < current.keys.length && current.keys[j] > 0 && key >= current.keys[j]) {
                j++;
            }

            // If no Kj exists, move to the last child
            if (j >= current.children.length) {
                j = current.children.length - 1;
            }

            // Move to the child pointed to by Pj
            current = current.children[j];
        }

        // Now in the leaf node, look for the key
        for (int j = 0; j < current.keys.length; j++) {
            if (current.keys[j] == key) {
                return current.values[j]; // Return the value pointed to by Pj
            }
        }

        // If key not found in the leaf node
        return "not found";
    }

    public static void main(String[] args) {
        // Example usage
        Node root = new Node(false, 3); // Create root node
        // Fill out your B-tree structure here as needed...

        String result = lookup(root, 42); // Perform lookup
        System.out.println(result);
    }
}
