package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> list;

    public boolean isUnivalTree(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for (int val: list) {
            if (val != list.get(0)) return false;
        }
        return true;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            int val = node.val;
            list.add(val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {

    }

}
