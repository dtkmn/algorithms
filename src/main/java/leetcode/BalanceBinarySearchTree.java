package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *      <a href="https://leetcode.com/problems/balance-a-binary-search-tree/">1382. Balance a Binary Search Tree</a>
 */
public class BalanceBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs_inorder(inorder, root);
        return buildTree(inorder, 0, inorder.size() - 1);
    }

    /**
     * Populate the list in sorted order with inorder transversal
     * @param list
     * @param node
     */
    private void dfs_inorder(List<Integer> list, TreeNode node) {
        if (node == null) return;
        dfs_inorder(list, node.left);
        list.add(node.val);
        dfs_inorder(list, node.right);
    }

    private TreeNode buildTree(List<Integer> inorder, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode leftNode = buildTree(inorder, start, mid - 1);
        TreeNode rightNode = buildTree(inorder, mid + 1, end);
        return new TreeNode(inorder.get(mid), leftNode, rightNode);
    }

}
