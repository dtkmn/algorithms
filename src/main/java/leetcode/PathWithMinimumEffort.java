package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/">...</a>
 *
 s */

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;
        int[][] directions = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        int[][] cost = new int[rowLen][colLen];
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int[] row: cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int c = curr[2];
            visited[i][j] = true;
            for (int[] direction: directions) {
                int ii = i + direction[0];
                int jj = j + direction[1];
                if (ii < 0 || ii >= rowLen || jj < 0 || jj >= colLen) continue;

                int diff = Math.abs(heights[i][j] - heights[ii][jj]);
                int maxDiff = Math.max(c, diff);

                if (!visited[ii][jj] && cost[ii][jj] > maxDiff) {
                    cost[ii][jj] = maxDiff;
                    pq.offer(new int[]{ii, jj, maxDiff});
                }
            }
        }
        for (int[] row: cost) {
            System.out.println(Arrays.toString(row));
        }
        return cost[rowLen - 1][colLen - 1];
    }

    public static void main(String[] args) {
        int minimumEffortPath = new PathWithMinimumEffort().minimumEffortPath(
                new int[][]{
                        new int[]{1, 2, 2},
                        new int[]{3, 8, 2},
                        new int[]{5, 3, 5}
                }
        );
        System.out.println(minimumEffortPath);

        int minimumEffortPath2 = new PathWithMinimumEffort().minimumEffortPath(
            new int[][]{
                new int[]{1, 10, 6, 7, 9, 10, 4, 9}
            }
        );
        System.out.println(minimumEffortPath2);
    }

}
