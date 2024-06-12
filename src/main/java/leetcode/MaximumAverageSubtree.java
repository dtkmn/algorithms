package leetcode;

/*
    https://leetcode.com/problems/maximum-average-subtree/
 */
public class MaximumAverageSubtree {

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

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }
    private double max = 0.0;
    public int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0,0};
        int[] leftValue = dfs(node.left);
        int[] rightValue = dfs(node.right);

        int sum = node.val + leftValue[0] + rightValue[0];
        int count = 1 + leftValue[1] + rightValue[1];
        double avg = sum * 1.0 / count;
        max = Math.max(max, avg);
        return new int[] {sum, count};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);
        System.out.println(
            new MaximumAverageSubtree().maximumAverageSubtree(root)
        );
    }

}
