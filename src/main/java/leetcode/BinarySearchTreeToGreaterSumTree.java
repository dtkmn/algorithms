package leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">1038. Binary Search Tree to Greater Sum Tree</a>
 */
public class BinarySearchTreeToGreaterSumTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) return val;
        int r = dfs(node.right, val);
        node.val += r;
        return dfs(node.left, node.val);
    }

    public TreeNode dfs_it(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();

            sum += curr.val;
            curr.val = sum;

            curr = curr.left;
        }
        return root;
    }

}
