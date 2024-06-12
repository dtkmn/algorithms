package leetcode;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    public class TreeNode {
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
    public int maxAncestorDiff(TreeNode root) {
        int rootVal = root.val;

        // subtree(root, rootVal, rootVal);
        // return maxDiff;

        return subtree2(root, rootVal, rootVal);
    }

    // ****** Approach 1
    // How to prevent this global variable
    private int maxDiff = 0;
    // Using post order transversal
    private void subtree(TreeNode node, int min, int max) {

        if (node == null) return;

        int currentVal = node.val;
        min = Math.min(min, currentVal);
        max = Math.max(max, currentVal);
        maxDiff = Math.max(maxDiff, Math.abs(max - min));
        // System.out.println("Current: " + currentVal + " Min: " + min + " Max: " + max + " Diff: " + maxDiff);

        subtree(node.left, min, max);
        subtree(node.right, min, max);

    }

    // ****** Approach 2
    // Using post order transversal without global variable
    // Time Complexity: O(N)
    private int subtree2(TreeNode node, int min, int max) {

        // Only calculate diff when we are in leaf children
        if (node == null) return max - min;

        int currentVal = node.val;
        min = Math.min(min, currentVal);
        max = Math.max(max, currentVal);

        int leftDiff = subtree2(node.left, min, max);
        int rightDiff = subtree2(node.right, min, max);

        return Math.max(leftDiff, rightDiff);

    }

}
