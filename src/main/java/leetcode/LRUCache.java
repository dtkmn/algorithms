package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/lru-cache/">...</a>
 *  12ms beat 96+%
 */
public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    Map<Integer, Node> mapStore = new HashMap<>();
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Check if the key existed
        if (mapStore.containsKey(key)) {
            Node node = mapStore.get(key);
            // Remove from the list and put it back to the tail
            remove(node);
            putOnTail(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {

        Node node = new Node(key, value);
        if (mapStore.containsKey(key)) {
            Node oldNode = mapStore.get(key);
            // remove this node
            remove(oldNode);
        } else if(mapStore.size() >= capacity) {
            Node remove = head.next;
            mapStore.remove(remove.key);
            remove(remove);
        }
        putOnTail(node);
        mapStore.put(key, node);

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void putOnTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        node.prev.next = node;
        tail.prev = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.put(4, 4);
//        cache.get(1);



//        ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//        [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
    }

}
