package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 */
public class CousinBinaryTree {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isCousins(TreeNode root, int x, int y) {

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean xfound = false, yfound = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (depth > 1) {
                    if (node.val == x) xfound = true;
                    if (node.val == y) yfound = true;
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x))
                        return false;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (xfound && yfound && depth > 1) return true;
            depth++;

        }

        return false;
    }

    public static void main(String[] args) {

    }

}
