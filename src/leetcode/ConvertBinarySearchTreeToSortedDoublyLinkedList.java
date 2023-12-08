package leetcode;


/*
    https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node head = null, prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        treeToDoublyList(root.left);
        // Inorder traversal and the first will be root.
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        treeToDoublyList(root.right);

        // At the very end, prev will be the last element
        prev.right = head;
        head.left = prev;

        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node res = new ConvertBinarySearchTreeToSortedDoublyLinkedList().treeToDoublyList(root);
        System.out.println(res.val);
    }

}
