package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/description/">...</a>
 *
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0) return -1;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[] xOffset = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] yOffset = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = -1;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                if (x == n - 1 && y == n - 1) return count;
                for (int j = 0; j < xOffset.length; j++) {
                    int nX = x + xOffset[j];
                    int nY = y + yOffset[j];
                    if (nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                    if (grid[nX][nY] == 0){
                        q.offer(new int[]{nX, nY});
                        grid[nX][nY] = -1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(
                new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 0}
                }
        );
        System.out.println(res);
    }
}
