package QuestionFour;
//The code implements an LFU cache in Java using a HashMap and a TreeMap. The LFU cache has a fixed size,
//        and when the cache reaches its maximum capacity, the least frequently used item is removed to make space
//        for a new item.The Node class represents an item in the cache, with a key-value pair, and a frequency count.
//        The DoubleLinkedList class represents a linked list of nodes, where the head node is the least recently used node.
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
    private Map<Integer, Node> valueMap = new HashMap<>(); //maps keys to nodes,
    private Map<Integer, Integer> countMap = new HashMap<>(); //keys to frequency counts,
    private TreeMap<Integer, DoubleLinkedList> frequencyMap = new TreeMap<>(); //maps frequency counts to lists of nodes with
    // that frequency.
    private final int size;

    public LFUCache(int n) {
        size = n;
    }

//    This method takes an integer argument key and returns the value associated with that key in the cache.
//    If the key is not in the cache or the cache size is zero, the method returns -1. If the key is in the cache,
//    the method updates the frequency count of the key in countMap and moves the corresponding node to the correct
//    position in the frequencyMap. The method then returns the value associated with the key.
    public int get(int key) {
        //empty
        if (!valueMap.containsKey(key) || size == 0) {
            return -1;
        }

        Node nodeTodelete = valueMap.get(key);
        Node node = new Node(key, nodeTodelete.value());
        int frequency = countMap.get(key);
        frequencyMap.get(frequency).remove(nodeTodelete);
        removeIfListEmpty(frequency);
        valueMap.remove(key); //removes key
        countMap.remove(key);
        valueMap.put(key, node);
        countMap.put(key, frequency + 1);
        frequencyMap.computeIfAbsent(frequency + 1, k -> new DoubleLinkedList()).add(node);
        return valueMap.get(key).value;
    }
//The put() method first checks if the cache is already at its maximum capacity,
// and if it is, removes the least frequently used item from the cache.
    public void put(int key, int value) {
        if (!valueMap.containsKey(key) && size > 0){

            Node node = new Node(key, value);

            if (valueMap.size() == size) {
                // remove the first node(LRU) from the list the of smallest frequency(LFU)
                int lowestCount = frequencyMap.firstKey();
                Node nodeTodelete = frequencyMap.get(lowestCount).head();
                frequencyMap.get(lowestCount).remove(nodeTodelete);
                removeIfListEmpty(lowestCount);

                int keyToDelete = nodeTodelete.key();
                valueMap.remove(keyToDelete);
                countMap.remove(keyToDelete);
            }
            frequencyMap.computeIfAbsent(1, k -> new DoubleLinkedList()).add(node);
            valueMap.put(key, node);
            countMap.put(key, 1);

        }
        else if(size > 0){
            Node node = new Node(key, value);
            Node nodeTodelete = valueMap.get(key);
            int frequency = countMap.get(key);
            frequencyMap.get(frequency).remove(nodeTodelete);
            removeIfListEmpty(frequency);
            valueMap.remove(key);
            countMap.remove(key);
            valueMap.put(key, node);
            countMap.put(key, frequency + 1);
            frequencyMap.computeIfAbsent(frequency + 1, k -> new DoubleLinkedList()).add(node);


        }
    }

    private void removeIfListEmpty(int frequency) {
        // remove from map if list is empty
        if (frequencyMap.get(frequency).len() == 0) {
            frequencyMap.remove(frequency);
        }
    }

    private class Node {
        private int key;
        private int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int key() {
            return key;
        }

        public int value() {
            return value;
        }
    }

    private class DoubleLinkedList {
        private int n;
        private Node head;
        private Node tail;

        public void add(Node node) {
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            n++;
        }

        public void remove(Node node) {

            if (node.next == null) tail = node.prev;
            else node.next.prev = node.prev;

            if (node.prev == null) head = node.next;
            else node.prev.next = node.next;

            n--;
        }

        public Node head() {
            return head;
        }

        public int len() {
            return n;
        }
    }
//print the LFU
    public static void main(String[] args) {
        LFUCache  cache = new LFUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // Output: 10

        cache.put(3, 30);

        System.out.println(cache.get(2)); // Output: -1

        System.out.println(cache.get(3)); // Output: 30

        cache.put(4, 40);

        System.out.println(cache.get(1)); // Output: -1

        System.out.println(cache.get(3)); // Output: 30

        System.out.println(cache.get(4)); // Output: 40
    }
}
