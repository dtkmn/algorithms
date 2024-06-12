package leetcode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">...</a>
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    };
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        boolean leftOk = inorder(node.left);
        if (!leftOk) return false;
        System.out.println(node.val);
        if (prev != null && node.val <= prev) return false;
        prev = node.val;
        return inorder(node.right);
    }
}
