package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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

    // Space Complexity: O(N) where N is number of nodes
    // Time Complexity: O(N)
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // Create a queue to store node on each level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            List<Integer> levelVals = new ArrayList<>();
            int currentSize = q.size();
            // Look at the nodes on current level
            for (int i = 0; i < currentSize; i++) {
                TreeNode remove = q.remove();
                if (remove != null) {
                    levelVals.add(remove.val);
                    if (remove.left != null) q.add(remove.left);
                    if (remove.right != null) q.add(remove.right);
                }
            }
            if (level % 2 == 0) Collections.reverse(levelVals);
            result.add(levelVals);
            level++;
        }

        return result;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> list: lists) {
            System.out.println(list);
        }
    }

}
