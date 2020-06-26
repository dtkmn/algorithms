package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

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
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    // StringBuilder version
    // It is faster but have to check we need separate builder with same content
    // when going through left and right nodes
    private static void dfs(TreeNode node, List<String> res, StringBuilder localPath) {
        if (node == null) {
            return;
        }
        int oldLength = localPath.length();
        localPath.append(node.val);
        if ((node.left == null) && (node.right == null)) {
            res.add(localPath.toString());
        } else {
            localPath.append("->");
            // if not both, we must make the first as new StringBuilder object ^^
//            dfs(node.left, res, new StringBuilder(localPath));
            dfs(node.left, res, localPath);
            dfs(node.right, res, localPath);
        }
        // The other approach to backtrack to original value
        localPath.delete(oldLength, localPath.length());
    }

    // String version, use it only because it is immutable and the code looks cleaner
    // BUT it is slower
    private static void dfs_str(TreeNode node, List<String> res, String localPath) {
        if (node == null) {
            return;
        }
        localPath += node.val;
        if ((node.left == null) && (node.right == null)) {
            res.add(localPath);
        } else {
            localPath += "->";
            dfs_str(node.left, res, localPath);
            dfs_str(node.right, res, localPath);
        }
    }

}
