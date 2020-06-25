package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> allPaths = new ArrayList<>();
        findPath(root, sum, allPaths, new ArrayList<>());

        return allPaths;
    }

    public static void findPath(TreeNode node, int sum, List<List<Integer>> paths, List<Integer> localPath) {
        if (node == null) return;
        localPath.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(localPath));
        } else {
            findPath(node.left, sum - node.val, paths, localPath);
            findPath(node.right, sum - node.val, paths, localPath);
        }
        // * Pop the last item from the list
        localPath.remove(localPath.size() - 1);
    }

}
