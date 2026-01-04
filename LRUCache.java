import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int hits;
    private int misses;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
        hits = 0;
        misses = 0;
    }

    private void addToFront(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            misses++;
            return -1;
        }
        hits++;
        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            Node newNode = new Node(key, value);

            if (map.size() == capacity) {
                map.remove(tail.key);
                removeNode(tail);
            }

            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    public void printStats() {
        System.out.println("Cache Hits: " + hits);
        System.out.println("Cache Misses: " + misses);
    }
}
