package leetcode;

/**
 *      <a href="https://leetcode.com/problems/find-distance-in-a-binary-tree/">1740. Find Distance in a Binary Tree</a>
 */
public class FindDistanceInBinaryTree {

    public int findDistance(TreeNode root, int p, int q) {
        // Find the LCA within p and q first
        TreeNode from = findLCA(root, p, q);
        // Then we calculate the distance from LCA to these points
        return find(from, p, 0) + find(from, q, 0);
    }

    private int find(TreeNode t, int value, int d) {
        if (t == null) return -1;
        if (t.val == value) return d;
        int left = find(t.left, value, 1 + d);
        if (left != -1) return left;
        return find(t.right, value, 1 + d);
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null? left: right;
    }

}
