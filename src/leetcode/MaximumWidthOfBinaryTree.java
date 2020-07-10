package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int width = 1;

        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        while (!q.isEmpty()) {

            int size = q.size();
            int left = -1, right = -1;

            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                int index = map.get(n);

                if (i == 0) left = index;
                else if (i == size - 1) right = index;

                if (n.left != null)  {
                    int value = index * 2 - 1;
                    map.put(n.left, value);
                    // System.out.println("Put Index Left: " + (index * 2 - 1));
                    q.offer(n.left);
                }

                if (n.right != null) {
                    int value = index * 2;
                    map.put(n.right, value);
                    // System.out.println("Put Index right: " + (index * 2));
                    q.offer(n.right);
                }

            }

            width = Math.max(width, right - left + 1);

        }

        return width;

    }

    public static void main(String[] args) {

    }

}
