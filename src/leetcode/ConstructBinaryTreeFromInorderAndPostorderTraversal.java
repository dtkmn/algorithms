package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *      <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">...</a>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int postRootIndex;
    private Map<Integer, Integer> indexPos = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postRootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexPos.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, postorder.length);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int lo, int hi) {
        if (lo > hi) return null;
        int rootVal = postorder[postRootIndex];
        int rootIndex = indexPos.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // Now where for left/right subtree
        postRootIndex--;
        root.right = helper(inorder, postorder, rootIndex + 1, hi);
        root.left = helper(inorder, postorder, lo, rootIndex - 1);

        return root;
    }

    public static void main(String[] args) {

    }

}
