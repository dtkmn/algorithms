package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">...</a>
 *
 */

public class UniqueBinarySearchTreesII {

    class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }
    private List<TreeNode>[][] dp = new ArrayList[9][9];
    List<TreeNode> generateTree(int start, int end) {
        System.out.println(start + ": " + end);
        List<TreeNode> tree = new ArrayList<>();
        if (start > end) {
            System.out.println("null created");
            tree.add(null);
            return tree;
        }
        if (dp[start][end] != null) return dp[start][end];

        for (int i = start; i <=end; i++) {
            // When start == end, left and right will be null and creating root node below
            List<TreeNode> leftSubTree = generateTree(start, i - 1);
            List<TreeNode> rightSubTree = generateTree(i + 1, end);
            for (TreeNode left: leftSubTree) {
                for (TreeNode right: rightSubTree) {
                    TreeNode root = new TreeNode(i, left, right);
                    System.out.println("Node created");
                    System.out.println(root);
                    tree.add(root);
                }
            }
        }
        dp[start][end] = tree;

        System.out.println(Arrays.toString(tree.toArray()));
        return dp[start][end];
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println(treeNodes.size());
    }

}
