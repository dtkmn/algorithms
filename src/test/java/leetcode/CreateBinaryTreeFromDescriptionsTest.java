package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateBinaryTreeFromDescriptionsTest {

    @Test
    void createBinaryTree() {
        CreateBinaryTreeFromDescriptions test = new CreateBinaryTreeFromDescriptions();
        TreeNode root = test.createBinaryTree(
            new int[][]{
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1},
            }
        );
        assertEquals(50, root.val);
        assertEquals(20, root.left.val);
        assertEquals(80, root.right.val);
        assertEquals(15, root.left.left.val);
        assertEquals(17, root.left.right.val);
        assertEquals(19, root.right.left.val);
    }

}