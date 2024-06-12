package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 */
public class FindModeInBinarySearchTree {

    private final Map<Integer, Integer> countMap = new HashMap<>();
    private int max = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = Collections.max(countMap.values());
        List<Integer> collected = countMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();
        return collected.stream().parallel().mapToInt(i -> i).toArray();
    }

    public int[] findMode_with_morris(TreeNode root) {
        int currNum = 0;
        int currStreak = 0;
        int maxStreak = 0;
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode friend = curr.left;
                // Find the right most node under current root
                while (friend.right != null) friend = friend.right;
                // And point its right back to curr
                friend.right = curr;
                // Remove link from curr to its left node
                TreeNode left = curr.left;
                curr.left = null;
                curr = left;
            } else {
                // we are in middle node
                int value = curr.val;
                if (currNum == value) {
                    currStreak++;
                } else {
                    currStreak = 1;
                    currNum = value;
                }
                if (currStreak == maxStreak) {
                    ans.add(currNum);
                }
                if (currStreak > maxStreak) {
                    ans = new ArrayList<>();
                    ans.add(currNum);
                    maxStreak = currStreak;
                }
                curr = curr.right;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] findMode_with_dfs_inorder(TreeNode root) {
        dfs_inorder(root);
        int currNum = 0;
        int currStreak = 0;
        int maxStreak = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < sortedList.size(); i++) {
            int value = sortedList.get(i);
            if (currNum == value) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = value;
            }
            if (currStreak == maxStreak) {
                ans.add(currNum);
            }
            if (currStreak > maxStreak) {
                ans = new ArrayList<>();
                ans.add(currNum);
                maxStreak = currStreak;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // Recursive
    public void dfs(TreeNode node) {
        if (node == null) return;
        countMap.put(node.val, countMap.getOrDefault(node.val,0) + 1);
        dfs(node.left);
        dfs(node.right);
    }

    private List<Integer> sortedList = new ArrayList<>();
    public void dfs_inorder(TreeNode node) {
        if (node == null) return;
        dfs_inorder(node.left);
        sortedList.add(node.val);
        dfs_inorder(node.right);
    }

    private Stack<TreeNode> stack = new Stack<>();
    public int[] dfs_stack(TreeNode root) {
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            countMap.put(popNode.val, countMap.getOrDefault(popNode.val, 0) + 1);
            if (popNode.left != null) stack.push(popNode.left);
            if (popNode.right != null) stack.push(popNode.right);
        }

        int max = Collections.max(countMap.values());
        List<Integer> collected = countMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();

        return collected.stream().mapToInt(i -> i).toArray();
    }

    private Queue<TreeNode> queue = new LinkedList<>();
    public int[] bfs(TreeNode root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            countMap.put(node.val, countMap.getOrDefault(node.val, 0) + 1);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int max = Collections.max(countMap.values());
        List<Integer> collected = countMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();

        return collected.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(
            Arrays.toString(new FindModeInBinarySearchTree().findMode(root))
        );

    }

}
