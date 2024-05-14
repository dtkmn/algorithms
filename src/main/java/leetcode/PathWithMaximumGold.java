package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/path-with-maximum-gold">...</a>
 *
 s */

public class PathWithMaximumGold {

    private final int[][] moves = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
    private int ans = 0;

    public int getMaximumGold(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] > 0) {
                    // Backtrack start
                    ans = Math.max(ans, dfs(grid, visited, 0, r, c));
                }
            }
        }
        return ans;
    }

    int dfs(int[][] grid, boolean[][] visited, int amount, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int localMax = 0;
        for (int[] move: moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            int subAmount = dfs(grid, visited, amount + grid[row][col], newRow, newCol);
            localMax = Math.max(localMax,  grid[row][col] + subAmount);
        }
        visited[row][col] = false;
        return localMax;
    }

    public static void main(String[] args) {
        int maximumGold = new PathWithMaximumGold().getMaximumGold(new int[][]{
                new int[]{0, 6, 0},
                new int[]{5, 8, 7},
                new int[]{0, 9, 0}
        });
        System.out.println(maximumGold);
    }

}
