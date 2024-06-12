package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    };

    // 0ms
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            return compare(root, root);
        }
        return false;
    }

    // We can compare t1.left/t2.right and t1.right/t2.left directly
    // using recursion as below
    private static boolean compare(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return compare(t1.left, t2.right) && compare(t1.right, t2.left);
    }

    // Initially using BFS and stack to loop through all the node values
    // Put them in List for later comparision, but too many process and must be slow!
    // 2ms
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            List<Integer> leftside = bfs(root.left, "left");
            List<Integer> rightside = bfs(root.right, "right");
            if (leftside.size() != rightside.size()) return false;
            for (int i = 0; i < leftside.size(); i++) {
                if (leftside.get(i).compareTo(rightside.get(i)) != 0) return false;
            }
            System.out.println(leftside);
            System.out.println(rightside);
            return true;
        }
        return false;
    }

    private static List<Integer> bfs(TreeNode root, String side) {
        List<Integer> curr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                curr.add(node.val);
                if (node.left != null || node.right != null) {
                    if ("left".equals(side)) {
                        stack.push(node.left == null ? new TreeNode(-1) : node.left);
                        stack.push(node.right == null ? new TreeNode(-1) : node.right);
                    }
                    if ("right".equals(side)) {
                        stack.push(node.right == null ? new TreeNode(-1) : node.right);
                        stack.push(node.left == null ? new TreeNode(-1) : node.left);
                    }
                }
            }
        }
        return curr;
    }

}
