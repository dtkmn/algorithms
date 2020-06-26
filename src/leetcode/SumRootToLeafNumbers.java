package leetcode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {

    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private static int ans = 0;
    private static void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }

}
