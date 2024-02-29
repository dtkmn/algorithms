package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 *  <a href="https://leetcode.com/problems/even-odd-tree/">...</a>
 */

public class EvenOddTree {
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
    
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int zeroOrOne = level % 2;
            int prev = zeroOrOne == 0? 0: 10000001;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // even-indexed level
                if (zeroOrOne == 0 && (current.val <= prev || current.val % 2 == 0)) return false;
                // odd-indexed level
                else if (zeroOrOne == 1 && (current.val >= prev || current.val % 2 == 1)) return false;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                prev = current.val;
            }
            level++;
        }
        return true;
    }
    public static void main(String[] args) {
    }

}
