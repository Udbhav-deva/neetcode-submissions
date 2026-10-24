class LRUCache {

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    
    // Dummy sentinel pointers
    private final Node left;
    private final Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy boundaries
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // Remove node from the linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Insert node at the rightmost side (Most Recently Used)
    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move accessed node to the most recently used position
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Remove old node value if it already exists
            remove(cache.get(key));
        }
        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // Evict the least recently used node if capacity exceeded
        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key); 
        }
    }
}
