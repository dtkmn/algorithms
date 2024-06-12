package leetcode;


/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private static TreeNode dfs(TreeNode node, int val) {
        if (node == null || node.val == val) return node;
        if (node.val > val) return dfs(node.left, val);
        return dfs(node.right, val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode res = searchBST(root, 7);
        System.out.println(res.val);

    }

}
