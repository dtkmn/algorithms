package leetcode;


/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
           TreeNode tmp = node.left;
           node.left = node.right;
           node.right = tmp;
           dfs(node.left);
           dfs(node.right);
        }
    }

    public static void main(String[] args) {

    }

}
