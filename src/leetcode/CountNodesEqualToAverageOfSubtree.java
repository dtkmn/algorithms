package leetcode;

/**
 * <a href="https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/">...</a>
 *
 */
public class CountNodesEqualToAverageOfSubtree {

    private int total;
    public int averageOfSubtree(TreeNode root) {
        dfsPostOrder(root);
        return total;
    }

    public int[] dfsPostOrder(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] leftSumCount = dfsPostOrder(node.left);
        int[] rightSumCount = dfsPostOrder(node.right);
        int sum = leftSumCount[0] + rightSumCount[0] + node.val;
        int count = leftSumCount[1] + rightSumCount[1] + 1;
        if (node.val == sum/count) total++;
        return new int[]{sum, count};
    }

    public static void main(String[] args) {

    }

}
