package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] row: adjacentPairs) {
            int left = row[0];
            int right = row[1];
            if (!graph.containsKey(left)) graph.put(left, new ArrayList<>());
            if (!graph.containsKey(right)) graph.put(right, new ArrayList<>());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }

        int root = 0;
        // Loop through the graph and root should have only one child
        for (int num: graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] ans = new int[graph.size()];
        int index = 0;
        int prev = 0;
        int curr = root;
        ans[index++] = curr;

        while (index < graph.size()) {
            for (int item: graph.get(curr)) {
                if (item != prev) {
                    ans[index++] = item;
                    prev = curr;
                    curr = item;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
