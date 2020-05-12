package leetcode;


/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    };

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findPathSum(root);
        return maxSum;
    }

    static int maxSum;

    // Time Complexity: O(N) , N refer to number of node
    // Space Complexity: O(1)
    static int findPathSum(TreeNode node) {
        if (node == null) return 0;
        int nodeVal = node.val;
        // Get the sum from left tree
        int L = findPathSum(node.left);
        // Get teh sum from right tree
        int R = findPathSum(node.right);
        // Compare with sum of left tree and current node value
        maxSum = Math.max(nodeVal + L, maxSum);
        // Compare with sum of right tree and current node value
        maxSum = Math.max(nodeVal + R, maxSum);
        // Compare with sum of left/right tree + current node value AND current node value alone
        maxSum = Math.max(Math.max(maxSum, nodeVal + L + R), nodeVal);
        // Further check since L and R would be below zero
        if (Math.max(L, R) > 0)
            return nodeVal + Math.max(L, R);
        else return nodeVal;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        System.out.println("Maximum Path Sum: " + BinaryTreeMaximumPathSum.maxPathSum(root));
//
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//        root.right.left.left = new TreeNode(7);
//        root.right.left.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(9);
//        System.out.println("Maximum Path Sum: " + BinaryTreeMaximumPathSum.maxPathSum(root));
//
//        root = new TreeNode(-1);
//        root.left = new TreeNode(-3);
//        System.out.println("Maximum Path Sum: " + BinaryTreeMaximumPathSum.maxPathSum(root));

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        System.out.println("Maximum Path Sum: " + BinaryTreeMaximumPathSum.maxPathSum(root));

        root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + BinaryTreeMaximumPathSum.maxPathSum(root));
    }

}
