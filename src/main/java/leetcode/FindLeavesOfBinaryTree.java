package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-leaves-of-binary-tree/">...</a>
 */
public class FindLeavesOfBinaryTree {

    private TreeNode root;
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return List.of();
        this.root = root;
        List<List<Integer>> ans = new ArrayList<>();
        while (this.root != null) {
            List<Integer> currentList = new ArrayList<>();
            dfs(this.root, null, -1, currentList);
            ans.add(currentList);
        }
        return ans;
    }
    public void dfs(TreeNode node, TreeNode parent, int leftOrRight, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            if (leftOrRight == 1) parent.left = null;
            else if (leftOrRight == 2) parent.right = null;
            else this.root = null;
            return;
        }
        if (node.left != null) dfs(node.left, node, 1, list);
        if (node.right != null) dfs (node.right, node,2, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> leaves = new FindLeavesOfBinaryTree().findLeaves(root);
        System.out.println(leaves);
    }

}
