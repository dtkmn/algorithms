package leetcode;


/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 */
public class InsertIntoASortedCircularLinkedList {

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        // When head is null, create new node for insertVal and return :)
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        compare(head, insertVal, head);
        return head;
    }

    private void insertInBetween(Node node, int val) {
        Node newNode = new Node(val);
        Node oldNext = node.next;
        node.next = newNode;
        newNode.next = oldNext;
    }

    // Iterative Approach
    // Time Complexity: O(N) i.e. Size of Linked list
    // Space Complexity: O(1)
    public Node insertIt(Node head, int insertVal) {
        // When head is null, create new node for insertVal and return :)
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node node = head;
        while (node.next != head) {
            int currentVal = node.val;
            int nextVal = node.next.val;
            // 1) When val is in between
            if (currentVal <= insertVal && insertVal <= nextVal) {
                insertInBetween(node, insertVal);
                return head;
            }
            // When from the 'max' to 'min'
            // We know it is the max and min val here :)
            // 2) When val is outside this bound
            if (currentVal > nextVal && (insertVal < nextVal || insertVal > currentVal)) {
                insertInBetween(node, insertVal);
                return head;
            }
            node = node.next;
        }
        // 3) Loop through the own list
        // All elements would be equal, or it's the single linked list
        insertInBetween(node, insertVal);
        return head;
    }

    // Recursive Approach
    // Time Complexity: O(N) i.e. Size of Linked list
    // Space Complexity: O(1)
    private void compare(Node node, int val, Node head) {
        int currentVal = node.val;
        // No NULL check required since it is circular linked list
        int nextVal = node.next.val;

        // When val is in between
        if (currentVal <= val && val <= nextVal) {
            insertInBetween(node, val);
            return;
        }

        // When from the 'max' to 'min'
        // When val is outside this bound
        if (currentVal > nextVal && (val < nextVal || val > currentVal)) {
            // We know it is the max and min val here :)
            insertInBetween(node, val);
            return;
        }

        // When it is the single node linked list
        // Already loop through the own list
        if (node.next == head) {
            insertInBetween(node, val);
            return;
        }

        compare(node.next, val, head);

    }

    public static void main(String[] args) {

    }

}
