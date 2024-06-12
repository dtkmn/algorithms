package leetcode;

import java.util.*;

/**
 *
 */
public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                ans = root;
                root = root.left;
            }
        }
        return ans;
    }

    public TreeNode dfs(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.val == p.val) return node;
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(
            new InorderSuccessorInBST().inorderSuccessor(root, new TreeNode(1)).val
        );
        // root = [5,3,6,2,4,null,null,1], p = 6
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(1);
//        System.out.println(
//            new InorderSuccessorInBST().inorderSuccessor(root, new TreeNode(6))
//        );
    }

}
