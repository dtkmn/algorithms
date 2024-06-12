package leetcode;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    // Time Complexity: O(N)
    // Space Complexity: O(N) => Recursive function call stack
    public static Node flatten(Node head) {
        if (head == null) return null;
        // Shadow pointer
        Node pre = new Node();
        dfs(head, pre);
        // 'Real' head prev should be 'null'
        pre.next.prev = null;
        return pre.next;
    }

    private static Node dfs(Node curr, Node pre) {

        if (curr == null) return pre;

        // System.out.println(node.val);
        // Make sure prev/next has proper value esp. on parent/child case
        curr.prev = pre;
        pre.next = curr;

        // Keep the next pointer to handle parent/child node
        Node next = curr.next;

        Node tail = dfs(curr.child, curr);

        // Set the child as null after process to achieve valid link list
        curr.child = null;

        // Using stored 'next' pointer here to keep processing linearly
        return dfs(next, tail);

    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;

    }

}
