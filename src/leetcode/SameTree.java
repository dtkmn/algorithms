package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public static void main(String[] args) {

    }

    // 0ms
    // Recursive Approach
    // Time Complexity: O(N)
    // Space Complexity: O(N) *Function stack
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 0ms
    // Iterative Approach
    // Time Complexity: O(N)
    // Space Complexity: O(N) i.e. 2xN on queues
    public boolean isSameTree_bfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        Queue<TreeNode> qp = new LinkedList<>();
        qp.add(p);
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(q);

        while (!qp.isEmpty() || !qq.isEmpty()) {
            int sizep = qp.size();
            int sizeq = qq.size();
            if (sizep != sizeq) return false;

            for (int i = 0; i < sizep; i++) {
                TreeNode np = qp.poll();
                TreeNode nq = qq.poll();
                if (np.val != nq.val) return false;

                if (np.left != null && nq.left != null) {
                    qp.add(np.left);
                    qq.add(nq.left);
                } else if (!(np.left == null && nq.left == null)) {
                    return false;
                }

                if (np.right != null && nq.right != null) {
                    qp.add(np.right);
                    qq.add(nq.right);
                } else if (!(np.right == null && nq.right == null)) {
                    return false;
                }
            }
        }

        return true;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
