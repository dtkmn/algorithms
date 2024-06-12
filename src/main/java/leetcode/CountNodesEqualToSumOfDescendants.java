package leetcode;


/**
 *  <a href="https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/">...</a>
 */

public class CountNodesEqualToSumOfDescendants {
    private class TreeNode {
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

    int count = 0;

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return count;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left + right == node.val) count++;
        return node.val + left + right;
    }
    public static void main(String[] args) {
    }

}
