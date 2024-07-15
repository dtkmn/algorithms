package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorOfABinaryTreeTest {

    @Test
    void lowestCommonAncestor() {
        LowestCommonAncestorOfABinaryTree system = new LowestCommonAncestorOfABinaryTree();
        TreeNode node5 = new TreeNode(5);
        TreeNode node0 = new TreeNode(0);
        TreeNode root = new TreeNode(3);
        root.left = node5;
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(1);
        root.right.left = node0;
        TreeNode ans1 = system.lowestCommonAncestor(root, node5, node0);
        assertEquals(root, ans1);
    }

}