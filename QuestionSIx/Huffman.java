package QuestionSIx;// Huffman Coding in Java 6a


import java.util.Comparator;
import java.util.PriorityQueue;


class HuffmanNode {
    int item;  // Frequency
    char c;    // Character
    HuffmanNode left;   // Left child of the node
    HuffmanNode right;  // Right child of the node
}

// compare HuffmanNodes based on their frequency
class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

public class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            // If the node is a leaf node and represents a character,
            System.out.println(root.c + "   |  " + s);
            return;
        }
        // Traverse the left subtree
        printCode(root.left, s + "0");
        // Traverse the right subtree
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        // Initialize the character array and their frequencies
        int n = 4;//size
        char[] charArray = { 'A', 'B', 'C', 'D' };
        int[] charfreq = { 5, 1, 6, 3 };

        // Create a priority queue and add each node to it
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.item = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;

        // Build the Huffman tree by merging two nodes with the smallest frequency at a time
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();  // Remove the smallest node from the priority queue

            HuffmanNode y = q.peek();
            q.poll();  // Remove the second smallest node from the priority queue

            HuffmanNode f = new HuffmanNode();
            f.item = x.item + y.item;  // Set the frequency of the new node to the sum of the frequencies of the merged nodes
            f.c = '-';  // Set the character of the new node to '-'
            f.left = x;  // Set the left child of the new node to the smallest node
            f.right = y;  // Set the right child of the new node to the second smallest node
            root = f;  // Set the new node as the root of the Huffman tree

            q.add(f);  // Add the new node to the priority queue
        }

        // Print the code for each leaf node of the Huffman tree
        printCode(root, "");
    }
}
