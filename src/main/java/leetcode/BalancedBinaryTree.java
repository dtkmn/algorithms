package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *      <a href="https://leetcode.com/problems/balanced-binary-tree/">...</a>
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int leftLevel = getLevelByBfs(root.left);
        int rightLevel = getLevelByBfs(root.right);
        System.out.println(leftLevel);
        System.out.println(rightLevel);
        return Math.abs(leftLevel - rightLevel) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getLevelByDfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getLevelByDfs(root.left), getLevelByDfs(root.right));
    }
    public int getLevelByBfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
//        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
//            count += size;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(
            new BalancedBinaryTree().isBalanced(root)
        );
    }

}
