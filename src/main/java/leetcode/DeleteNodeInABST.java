package leetcode;

import java.util.Arrays;

/**
 *      <a href="https://leetcode.com/problems/delete-node-in-a-bst/">...</a>
 */
public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                TreeNode s = successor(root);
                root.val = s.val;
                return deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root).val;
                return deleteNode(root.left, root.val);
            }
        }

        return root;
    }

    private TreeNode successor(TreeNode node) {
        // When calling successor method, we suppose the node itself has right child.
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    public static void main(String[] args) {

    }

}
