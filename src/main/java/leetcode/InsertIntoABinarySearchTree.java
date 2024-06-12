package leetcode;


/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Iterative Approach, 0ms
    public TreeNode insertIntoBST_it(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
        }
        return new TreeNode(val);
    }

    // Recursion Approach, 0ms
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode curr, int val) {
        if (val > curr.val) {
            if (curr.right == null) {
                curr.right = new TreeNode(val);
            } else dfs(curr.right, val);
        } else {
            if (curr.left == null) curr.left = new TreeNode(val);
            else dfs(curr.left, val);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);


    }

}
