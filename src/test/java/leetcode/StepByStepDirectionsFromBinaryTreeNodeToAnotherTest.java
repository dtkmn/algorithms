package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepByStepDirectionsFromBinaryTreeNodeToAnotherTest {

    @Test
    void getDirections() {
        StepByStepDirectionsFromBinaryTreeNodeToAnother system = new StepByStepDirectionsFromBinaryTreeNodeToAnother();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        String ans1 = system.getDirections(root, 3, 6);
        assertEquals("UURL", ans1);
    }
}