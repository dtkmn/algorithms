package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    // BFS Approach
    public static int orangesRotting_bfs(int[][] grid) {

        int fresh = 0;
        int R = grid.length, C = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Store all initial '2' in queue and start from those
                if (grid[i][j] == 2) q.offer(new int[] { i, j });
                // Count initial '1's
                else if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] ops = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
        int minutes = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            boolean change = false;
            for (int i = 0; i < size; i++) {
                int[] pair = q.poll();
                for (int[] op: ops) {
                    int x = pair[0] + op[0];
                    int y = pair[1] + op[1];
                    if (x >= 0 && x < R && y >=0 && y < C
                            && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                        change = true;
                        fresh--;
                    }
                }
            }
            if (change) minutes++;
        }

        return fresh == 0? minutes : -1;
    }

    // Using normal straight forward thinking implementation
    public static int orangesRotting(int[][] grid) {

        int minutes = 0;
        boolean done = false, hasOne = false;
        int countOne = 0;

        while (!done) {

            done = true;
            // Count 1s on every minute
            countOne = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int allzero = 0;
                    if (grid[i][j] == 1) {
                        countOne++;
                        hasOne = true;
                        if (i + 1 < grid.length) {
                            if (grid[i+1][j] == 2) {
                                grid[i][j] = -2;
                                done = false;
                            } else if (grid[i+1][j] == 0) allzero++;
                        } else allzero++;
                        if (j + 1 < grid[0].length) {
                            if (grid[i][j + 1] == 2) {
                                grid[i][j] = -2;
                                done = false;
                            } else if (grid[i][j + 1] == 0) allzero++;
                        } else allzero++;
                        if (i - 1 >= 0) {
                            if (grid[i-1][j] == 2) {
                                grid[i][j] = -2;
                                done = false;
                            } else if (grid[i - 1][j] == 0) allzero++;
                        } else allzero++;
                        if (j - 1 >= 0) {
                            if (grid[i][j - 1] == 2) {
                                grid[i][j] = -2;
                                done = false;
                            } else if (grid[i][j - 1] == 0) allzero++;
                        } else allzero++;
                        if (allzero == 4) return -1;
                    }
                }
            }
            if (!hasOne) return 0;

            if (!done) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == -2) grid[i][j] = 2;
                    }
                }
                minutes++;
            }

        }

        // when still have one after it's 'done'
        if (countOne > 0) return -1;

        return minutes;
    }

    public static void main(String[] args) {

        System.out.println(orangesRotting_bfs(new int[][] {
            { 2, 1, 1 },
            { 1, 1, 0 },
            { 0, 1, 1 }
        }));

        System.out.println(orangesRotting(new int[][] {
            { 0, 2 }
        }));

        System.out.println(orangesRotting(new int[][] {
            {2},{2},{1},{0},{1},{1}
        }));

    }

}
