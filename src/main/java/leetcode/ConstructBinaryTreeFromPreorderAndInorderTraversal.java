package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">...</a>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int preRootIndex;
    private Map<Integer, Integer> indexPos = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            indexPos.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, preorder.length);
    }

    public TreeNode helper(int[] inorder, int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        int rootVal = preorder[preRootIndex];
        int rootIndex = indexPos.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // Now where for left/right subtree
        preRootIndex++;
        root.left = helper(inorder, preorder, lo, rootIndex - 1);
        root.right = helper(inorder, preorder, rootIndex + 1, hi);

        return root;
    }

    public TreeNode helper2(int[] inorder, int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        int rootValue = preorder[preRootIndex];
        TreeNode currentRoot = new TreeNode(rootValue);
        int rootIndexInOrder = indexPos.get(rootValue);
        // left first when doing with preorder :)
        currentRoot.left = helper2(inorder, preorder, lo, rootIndexInOrder - 1);
        currentRoot.right = helper2(inorder, preorder, rootIndexInOrder + 1, hi);
        return currentRoot;
    }

    public static void main(String[] args) {

    }

}
