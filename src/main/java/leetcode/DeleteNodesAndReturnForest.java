package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-and-return-forest/">1110. Delete Nodes And Return Forest</a>
 */
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for (int t: to_delete) {
            deleteSet.add(t);
        }
        dfs(root, null, false, ans, deleteSet);
        if (!deleteSet.contains(root.val)) {
            ans.add(root);
        }
        return ans;
    }

    private void dfs(TreeNode from, TreeNode parent, boolean left, List<TreeNode> ans, Set<Integer> deleteSet) {
        if (from == null) return;
        dfs(from.left, from, true, ans, deleteSet);
        dfs(from.right, from, false, ans, deleteSet);
        int val = from.val;
        if (deleteSet.contains(val)) {
            if (from.left != null) {
                ans.add(from.left);
            }
            if (from.right != null) {
                ans.add(from.right);
            }
            if (parent != null) {
                if (left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

}
