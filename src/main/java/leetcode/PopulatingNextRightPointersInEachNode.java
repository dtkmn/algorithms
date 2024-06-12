package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *      <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">...</a>
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (prev != null) prev.next = node;
                prev = node;
            }
        }
        return root;
    }

    // Is it possible to make it using constant space?
    public Node connect2(Node root) {
        Node leftmost = root;
        // Since it is perfect binary tree
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // First connection: common parent
                head.left.next = head.right;
                // Using next pointer from previous/upper level
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
