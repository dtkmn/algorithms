package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDistanceInBinaryTreeTest {

    @Test
    void findDistance() {
        FindDistanceInBinaryTree system = new FindDistanceInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        int ans1 = system.findDistance(root, 5, 0);
        assertEquals(3, ans1);
    }
}