package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/description/">...</a>
 *
 */

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice_BellmanFord(int n, int[][] flights, int src, int dst, int k) {
        // Bellman Ford implementation
        int[][] dp = new int[k + 2][n];
        for (int r = 0; r < dp.length; r++) {
            Arrays.fill(dp[r], Integer.MAX_VALUE);
            dp[r][src] = 0;
        }
        // Loop through k + 1 times
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight: flights) {
                int from = flight[0];
                int to = flight[1];
                int p = flight[2];
                if (dp[i - 1][from] < Integer.MAX_VALUE) {
                    dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + p);
                }
            }
        }

        for (int[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[k + 1][dst] == Integer.MAX_VALUE? -1: dp[k + 1][dst];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.computeIfAbsent(from, v -> new ArrayList<>()).add(new int[] { to, price });
        }

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
//        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int level = 0;

        while (!q.isEmpty()) {
            if (++level > k + 2) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int city = poll[0];
                int p = poll[1];
                if (city == dst) {
                    ans = Math.min(ans, p);
                } else if (cost[city] > p) {
                    cost[city] = p;
                    if (graph.containsKey(city)) {
                        for (int[] neighbour : graph.get(city)) {
                            if (cost[neighbour[0]] > neighbour[1] + p) {
                                q.offer(new int[]{neighbour[0], neighbour[1] + p});
                            }
                        }
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE? -1: ans;
    }

    public static void main(String[] args) {
        int cheapestPrice = new CheapestFlightsWithinKStops().findCheapestPrice_BellmanFord(
                4,
                new int[][]{
                    new int[]{0, 1, 100},
                    new int[]{1, 2, 100},
                    new int[]{2, 0, 100},
                    new int[]{1, 3, 600},
                    new int[]{2, 3, 200}
                },
                0,
                3,
                1
        );
        System.out.println(cheapestPrice);
    }

}
