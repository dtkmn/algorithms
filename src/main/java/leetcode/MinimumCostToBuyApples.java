package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-buy-apples/">...</a>
 *
 s */

public class MinimumCostToBuyApples {

    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        // Save all edges with cost to the graph map
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road: roads) {
            graph.computeIfAbsent(road[0], v -> new ArrayList<>()).add(new int[] {road[1], road[2]});
            graph.computeIfAbsent(road[1], v -> new ArrayList<>()).add(new int[] {road[0], road[2]});
        }

        long[] ans = new long[n];
        final int factor = k + 1;

        // Loop through each vertex
        for (int i = 1; i <= n; i++) {
            // Create cost array with infinite as default except the source
            int[] cost = new int[n + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            int localAns = Integer.MAX_VALUE;
            // Create Priority Queue with cost as ordering condition
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            pq.offer(new int[]{i, 0});
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int currPos = curr[0];
                int currCost = curr[1];
                int t = factor * currCost + appleCost[currPos - 1];
                if (cost[currPos] > t) {
                    cost[currPos] = t;
                    localAns = Math.min(localAns, cost[currPos]);
                    if (graph.containsKey(currPos)) {
                        List<int[]> neighbours = graph.get(currPos);
                        for (int[] neighbour: neighbours) {
                            int nCost = neighbour[1] + currCost;
                            int checkCost = nCost * factor + appleCost[neighbour[0] - 1];
                            if (cost[neighbour[0]] > checkCost) {
                                pq.offer(new int[]{neighbour[0], nCost});
                            }
                        }
                    }
                }
            }
            ans[i-1] = localAns == Integer.MAX_VALUE? -1 : localAns;
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] cost = new MinimumCostToBuyApples().minCost(
                4,
                new int[][]{
                        new int[]{1, 2, 4},
                        new int[]{2, 3, 2},
                        new int[]{2, 4, 5},
                        new int[]{3, 4, 1},
                        new int[]{1, 3, 4}
                },
                new int[]{56, 42, 102, 301},
                2
        );
        System.out.println(Arrays.toString(cost));
    }

}
