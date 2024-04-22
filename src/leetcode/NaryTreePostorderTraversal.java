package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">...</a>
 */
public class NaryTreePostorderTraversal {

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

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }

    void dfs(Node node) {
        if (node == null) return;
        for (Node n: node.children) {
            dfs(n);
        }
        ans.add(node.val);
    }

    public List<Integer> postorder_bfs(Node root) {
        if (root == null) return List.of();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node pee = stack.pop();
            ans.addFirst(pee.val);
            for (Node p: pee.children) {
                stack.push(p);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
