package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">...</a>
 */
public class NaryTreePreorderTraversal {

    private class Node {
        int val;
        List<Node> children;
        Node(int x) {
            this.val = x;
        }
        Node(int x, List<Node> children) {
            this.val = x;
            this.children = children;
        }
    };

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    void dfs(Node node) {
        if (node == null) return;
        ans.add(node.val);
        for (Node n: node.children) {
            dfs(n);
        }
    }

    public List<Integer> preorder_bfs(Node root) {
        if (root == null) return List.of();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            ans.add(n.val);
            for (Node c: n.children.reversed()) {
                stack.push(c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
