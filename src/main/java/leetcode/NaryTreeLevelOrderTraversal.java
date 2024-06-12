package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">...</a>
 */
public class NaryTreeLevelOrderTraversal {

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

    /**
     * Time Complexity: O(N), where N is the number of nodes
     * Space Complexity: O(N), worst case is all the nodes
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node p = q.poll();
                l.add(p.val);
                for (Node n: p.children) {
                    q.offer(n);
                }
            }
            ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
