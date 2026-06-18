class LRUCache {
    // Node for doubly linked list
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
    // stores key -> node
    HashMap<Integer, Node> map;
    // maximum size
    int capacity;
    // dummy nodes
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // Create empty doubly linked list
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        // If key doesn't exist
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // This node was used,
        // so move it to the front
        remove(node);
        insert(node);
        return node.value;
    }
    public void put(int key, int value) {
        // If key already exists
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }
        // Create new node
        Node newNode = new Node(key,value);
        // Add to map
        map.put(key,newNode);
        // Add to front
        insert(newNode);
        // If size exceeds capacity
        if (map.size() > capacity) {
            // remove least recently used node
            Node lru = tail.prev;
            remove(lru);
            // remove from hashmap
            map.remove(lru.key);
        }
    }
    // Remove node from linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // Add node after head
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}