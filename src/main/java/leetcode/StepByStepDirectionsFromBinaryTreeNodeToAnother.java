package leetcode;

/**
 *      <a href="https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/">2096. Step-By-Step Directions From a Binary Tree Node to Another</a>
 */
public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        backtrack(lca, startValue, s);
        backtrack(lca, destValue, d);
        return s.toString().replaceAll(".", "U") + d;
    }

    private boolean backtrack(TreeNode node, int value, StringBuilder curr) {
        if (node == null) return false;
        if (node.val == value) return true;

        curr.append("L");
        if (backtrack(node.left, value, curr)) {
            return true;
        }
        curr.deleteCharAt(curr.length() - 1);

        curr.append("R");
        if (backtrack(node.right, value, curr)) {
            return true;
        }
        curr.deleteCharAt(curr.length() - 1);

        return false;
    }

    private TreeNode findLCA(TreeNode node, int s, int d) {
        if (node == null || node.val == s || node.val == d) return node;
        TreeNode left = findLCA(node.left, s, d);
        TreeNode right = findLCA(node.right, s, d);
        if (left != null && right != null) return node;
        return left != null? left: right;
    }

}
