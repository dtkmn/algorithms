package leetcode;

/**
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        max = Math.max(max, leftSum + rightSum);
        return 1 + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));

    }

}
