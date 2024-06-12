package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">...</a>
 *
 */

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int c = time[2];
            edges.computeIfAbsent(from, v -> new ArrayList<>()).add(new int[] { to, c });
        }

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        int cost = Integer.MIN_VALUE;
//        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.offer(new int[] { k, 0 } );

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int localPos = current[0];
            int localCost = current[1];
            if (costs[localPos] > localCost) {
                costs[localPos] = localCost;
                if (edges.containsKey(localPos)) {
                    for (int[] edge : edges.get(localPos)) {
                        q.offer(new int[]{edge[0], edge[1] + localCost});
                    }
                }
            }
        }
        for (int i = 1; i < costs.length; i++) {
            cost = Math.max(cost, costs[i]);
        }
        return cost == Integer.MAX_VALUE? -1 : cost;
    }

    public static void main(String[] args) {
//        int networkDelayTime = new NetworkDelayTime().networkDelayTime(
//                new int[][]{
//                        new int[]{ 2, 1, 1 },
//                        new int[]{ 2, 3, 1 },
//                        new int[]{ 3, 4, 1 }
//                },
//                4,
//                2
//        );
//        System.out.println(networkDelayTime);

        int networkDelayTime2 = new NetworkDelayTime().networkDelayTime(
                new int[][]{
                        new int[]{ 1, 2, 1 },
                        new int[]{ 2, 3, 2 },
                        new int[]{ 1, 3, 4 }
                },
                3,
                1
        );
        System.out.println(networkDelayTime2);
    }

}
