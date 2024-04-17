package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/add-one-row-to-tree/">...</a>
 */
public class AddOneRowToTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
    }

    /**
     *
     * Time Complexity: O(N) number of nodes in the tree
     * Space Complexity: O(x) The size of queue, which is the max number of nodes at any level
     *
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode p = queue.poll();
                    TreeNode temp = p.left;
                    p.left = new TreeNode(val);
                    p.left.left = temp;
                    temp = p.right;
                    p.right = new TreeNode(val);
                    p.right.right = temp;
                }
                break;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode p = queue.poll();
                    if (p.left != null) queue.offer(p.left);
                    if (p.right != null) queue.offer(p.right);
                }
            }
            level++;
        }
        return root;
    }

}
