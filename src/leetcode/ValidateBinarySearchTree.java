package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(isValidBST(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    };

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Using 'long' type here since test cases include node value == Integer.MAX_VALUE
    private static boolean dfs(TreeNode node, long min, long max) {
        if (node == null) return true;
        // Under left node, always smaller than current node value
        boolean leftOk = dfs(node.left, min, node.val);
        // In contrast, under right node always larger than current node value
        boolean rightOk = dfs(node.right, node.val, max);
        // Make sure both left/right side ok and current node value also
        return leftOk && rightOk && node.val > min && node.val < max;
    }

}
