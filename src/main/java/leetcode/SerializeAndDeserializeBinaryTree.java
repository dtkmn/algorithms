package leetcode;

import java.util.*;

/**
 *      <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">...</a>
 */
public class SerializeAndDeserializeBinaryTree {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        sb = new StringBuilder();
        sb.append(root.val);
        dfs(root.left);
        dfs(root.right);
        return sb.toString();
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            sb.append(",").append("null");
            return;
        }
        sb.append(",").append(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] strings = data.split(",");
//        if (strings[0] == null || strings[0].equals("null")) return null;
        List<String> list = new LinkedList<>(Arrays.asList(strings));
        return decode(list);
    }

    public TreeNode decode(List<String> list) {
        if (list.isEmpty()) return null;
        String removed = list.remove(0);
        if (removed.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(removed));
        node.left = decode(list);
        node.right = decode(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(
            new SerializeAndDeserializeBinaryTree().serialize(root)
        );
    }

}
