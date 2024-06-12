package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
 *
 */
public class FindAllTheLonelyNodes {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public List<Integer> getLonelyNodes_dfs(TreeNode root) {
         dfs(root);
         return res;
    }

    private List<Integer> res = new ArrayList<>();
    // Recursive Approach
    // Time Complexity: O(N) i.e. Number of nodes
    // Space Complexity: O(N) i.e. Function stack
    private void dfs(TreeNode node) {
        if (node == null) return;
        // This condition confirm each parent only has one child
        if ((node.left == null || node.right == null) && (node.left != node.right)) {
            if (node.left != null) res.add(node.left.val);
            else res.add(node.right.val);
        }
        dfs(node.left);
        dfs(node.right);
    }

    // Iterative Approach
    // Time Complexity: O(N) i.e. Number of nodes
    // Space Complexity: O(N) i.e. Queue size
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if ((curr.left == null || curr.right == null) && (curr.left != curr.right)) {
                if (curr.left != null) res2.add(curr.left.val);
                else res2.add(curr.right.val);
            }
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }

        return res2;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
