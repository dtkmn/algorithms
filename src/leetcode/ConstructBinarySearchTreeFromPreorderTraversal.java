package leetcode;


/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 */

public class ConstructBinarySearchTreeFromPreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        // First pos always the root from preorder
        TreeNode root = new TreeNode(preorder[0]);
        // Loop through every point from the root and compare
        for (int i = 1; i < preorder.length; i++) {
            buildTree(root, preorder[i]);
        }
        return root;
    }

    public static void buildTree(TreeNode node, int value) {
        if (node == null) return;
        if (value < node.val) {
            if (node.left != null) {
                node = node.left;
                buildTree(node, value);
            } else {
                node.left = new TreeNode(value);
            }
        } else {
            if (node.right != null) {
                node = node.right;
                buildTree(node, value);
            } else {
                node.right = new TreeNode(value);
            }
        }
    }

    public static void main(String[] args) {
        // 8,5,10,1,7,null,12
        TreeNode treeNode = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(treeNode.val);
    }

}
