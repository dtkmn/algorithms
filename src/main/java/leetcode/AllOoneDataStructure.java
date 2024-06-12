package leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/all-oone-data-structure/">...</a>
 */
public class AllOoneDataStructure {

    class Node {
        String value;
        int count;
        Node prev;
        Node next;
    }

    private Map<String, Node> countMap;
    private TreeSet<String> minSet;
    private TreeSet<String> maxSet;

    // We need only one list in ascending order, but update head and tail if needed
    private Node head;
    private Node tail;
    public AllOoneDataStructure() {
        countMap = new HashMap<>();
        head = new Node();
//        minSet = new TreeSet<>((key1, key2) -> {
//            int count1 = countMap.getOrDefault(key1, 0);
//            int count2 = countMap.getOrDefault(key2, 0);
//            if (count1 == count2) return key1.compareTo(key2);
//            return count1 - count2;
//        });
//        maxSet = new TreeSet<>((key1, key2) -> {
//            int count1 = countMap.getOrDefault(key1, 0);
//            int count2 = countMap.getOrDefault(key2, 0);
//            if (count1 == count2) return key2.compareTo(key1);
//            return count1 - count2;
//        });
    }

    public void inc(String key) {
        if (countMap.containsKey(key)) {
            Node n = countMap.get(key);
            n.count++;
            countMap.put(key, n);
        } else {
            Node n = new Node();
            n.value = key;
            n.count = 1;
            countMap.put(key, n);
        }
    }

    private void insertNode(Node n) {
        if (head.next == null) {
            head.next = n;
            n.prev = head;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.count > n.count) {
                Node p = current.prev;
                p.next = n;
                n.prev = p;
                current.prev = n;
                n.next = current;
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = n;
        tail = n;
        n.prev = prev;
    }

    private void removeNode(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    private void updateNodePosition(Node n, boolean countUp) {
        if (countUp) {
            // Start from next node
            Node prev = n;
            Node current = n.next;
            while (current != null) {
                if (current.count == prev.count) break;
                if (current.count < prev.count) {
                    // current.count < prev.count
                    // swap
                    Node prevprev = prev.prev;
                    prevprev.next = current;
                    current.prev = prevprev;
                    prev.next = current.next;
                    prev.prev = current;
                    current.next = prev;

//                    prev = current;
//                    current = current.next;
                    current = prev;
                }
            }
        } else { // For decremental
            // Start from previoud node
            Node prev = n.prev;
            Node current = n;

        }
    }

//    public void dec(String key) {
//        int count = countMap.get(key);
//        if (count == 1) {
//            countMap.remove(key);
//            minSet.remove(key);
//            maxSet.remove(key);
//        }
//        else countMap.put(key, count - 1);
//    }

    public String getMaxKey() {
        if (maxSet.isEmpty()) return "";
        while (!countMap.containsKey(maxSet.first())) {
            System.out.println(
                "Remove (from MaxSet) ... " +
                maxSet.removeFirst()
            );
        }
        return maxSet.first();
    }

    public String getMinKey() {
        if (minSet.isEmpty()) return "";
        while (!countMap.containsKey(minSet.first())) {
            System.out.println(
                "Remove (from MinSet) ... " +
                minSet.removeFirst()
            );
        }
        return minSet.first();
    }

    public static void main(String[] args) {
        AllOoneDataStructure system = new AllOoneDataStructure();
        system.inc("a");
        system.inc("b");
        system.inc("c");
        system.inc("d");

        system.inc("a");
        system.inc("b");
        system.inc("c");
        system.inc("d");

        system.inc("c");
        system.inc("d");
        system.inc("d");
        system.inc("a");

        System.out.println(system.getMinKey());
    }
}
