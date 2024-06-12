package leetcode;


/**
 * <a href="https://leetcode.com/problems/smallest-string-starting-from-leaf/">...</a>
 */
public class SmallestStringStartingFromLeaf {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(
            new SmallestStringStartingFromLeaf().smallestFromLeaf(root)
        );
    }

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root).toString();
    }

    StringBuilder dfs(TreeNode node) {
        if (node == null) return new StringBuilder();
        char nodeVal = (char) (node.val + 'a');
//        StringBuilder leftSb = new StringBuilder().append(nodeVal);
//        StringBuilder rightSb = new StringBuilder().append(nodeVal);
//        System.out.println(leftSb);
//        System.out.println(rightSb);
        StringBuilder left = dfs(node.left);
        left.append(nodeVal);
        StringBuilder right = dfs(node.right);
        right.append(nodeVal);
        System.out.println(left + ", " + right);
        return left.compareTo(right) <= 0 ? left: right;
    }

}
