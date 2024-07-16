package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/path-sum-iii/">437. Path Sum III</a>
 */
public class PathSumIII {

    private int count = 0;
    private Map<Long, Integer> prefixSumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return count;
    }

    private void dfs(TreeNode node, int targetSum, long pathSum) {
        if (node == null) return;
        pathSum += node.val;
        if (pathSum == targetSum) {
            count++;
        }
        count += prefixSumCount.getOrDefault(pathSum - targetSum, 0);
        prefixSumCount.put(pathSum, 1 + prefixSumCount.getOrDefault(pathSum, 0));

        dfs(node.left, targetSum, pathSum);
        dfs(node.right, targetSum, pathSum);

        prefixSumCount.put(pathSum, prefixSumCount.get(pathSum) - 1);
    }

}
