package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Iterative Approach
    static List<Integer> inorderTraversalIt(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Add root and all its left nodes down to leaf
            while (current != null) {
                System.out.println("Add: " + current.val);
                stack.add(current);
                current = current.left;
            }

            // Should be left first then middle
            TreeNode n = stack.pop();
            System.out.println("Pop: " + n.val);
            res.add(n.val);
            current = n.right;

        }
        return res;
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    // Recursive approach
    static void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversalIt(root));
    }

}
