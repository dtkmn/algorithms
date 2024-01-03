package leetcode;


/**
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">...</a>
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

    private int index = 0;
    private int[] preorder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int start, int end) {
        if (index == preorder.length) return null;
        int value = preorder[index];
        if (value < start || value > end) return null;
        index++;
        TreeNode currentNode = new TreeNode(value);
        currentNode.left = buildTree(start, value);
        currentNode.right = buildTree(value, end);
        return currentNode;
    }


    // When it is postorder, the implementation is similar with minor ordering changes
    public static TreeNode bstFromPostorder(int[] postorder) {
        postOrderIndex = postorder.length - 1;
        return buildTreeFromPostOrder(Integer.MIN_VALUE, Integer.MAX_VALUE, postorder);
    }

    private static int postOrderIndex;
    public static TreeNode buildTreeFromPostOrder(int start, int end, int[] postorder) {
        if (postOrderIndex < 0) return null;
        int value = postorder[postOrderIndex];
        if (value < start || value > end) return null;
        postOrderIndex--;
        TreeNode currentNode = new TreeNode(value);
        currentNode.right = buildTreeFromPostOrder(value, end, postorder);
        currentNode.left = buildTreeFromPostOrder(start, value, postorder);
        return currentNode;
    }

    public static void main(String[] args) {
        // 8,5,10,1,7,null,12
        TreeNode treeNode = new ConstructBinarySearchTreeFromPreorderTraversal()
                .bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(treeNode.val);
        TreeNode tree2 = bstFromPostorder(new int[]{1,7,5,12,10,8});
        System.out.println(tree2.val);
    }

}
