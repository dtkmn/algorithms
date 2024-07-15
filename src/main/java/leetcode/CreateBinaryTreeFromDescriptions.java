package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *      <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions/">2196. Create Binary Tree From Descriptions</a>
 */
public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map from Integer to its real TreeNode
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Map from child integer to its parent
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int[] d: descriptions) {
            TreeNode parent = nodeMap.getOrDefault(d[0], new TreeNode(d[0]));
            TreeNode child = nodeMap.getOrDefault(d[1], new TreeNode(d[1]));
            if (d[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            nodeMap.put(d[0], parent);
            nodeMap.put(d[1], child);
            parentMap.put(d[1], d[0]);
        }
        // Use any random points to find the root
        int p = descriptions[0][0];
        while (p != 0) {
            if (!parentMap.containsKey(p)) return nodeMap.get(p);
            p = parentMap.get(p);
        }
        return null;
    }

}
