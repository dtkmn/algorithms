package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/path-sum-iv/">666. Path Sum IV</a>
 */
public class PathSumIV {

    public int pathSum(int[] nums) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        TreeNode head = null;
        int level = 1;

        for (int n: nums) {
            while (n / 100 > level) {
                level++;
            }
            if (n / 100 == level) {
                TreeNode node = new TreeNode(n % 10);

                int key = n / 10; // eg. 215 / 10 = 21
                int pos = key % 10; // eg. 215 -> 215 / 10 % 10 = 21 % 10 = 1

                if (level != 1) {
                    int parentLevel = level - 1;
                    int parentPos = (pos + 1) / 2;
                    TreeNode nn = nodeMap.get(parentLevel * 10 + parentPos);
                    if (pos % 2 == 1) {
                        nn.left = node;
                    } else {
                        nn.right = node;
                    }
                } else {
                    head = node;
                }
                nodeMap.put(key, node);
            }
        }
        return dfs(head, 0);
    }

    private int dfs(TreeNode root, int currSum) {
        if (root == null) return 0;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            return currSum;
        }
        return dfs(root.left, currSum) + dfs(root.right, currSum);
    }

}
