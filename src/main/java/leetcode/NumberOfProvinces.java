package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">...</a>
 *
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[] visited, int r) {
        visited[r] = true;
        for (int col = 0; col < grid[r].length; col++) {
            if (grid[r][col] == 1 && !visited[col]) {
                dfs(grid, visited, col);
            }
        }
    }

    public int findCircleNum_bfs(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                bfs(isConnected, visited, i);
            }
        }
        return count;
    }

    void bfs(int[][] grid, boolean[] visited, int row) {
        visited[row] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(row);
        while (!queue.isEmpty()) {
            int r = queue.poll();
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1 && !visited[c]) {
                    queue.offer(c);
                    visited[c] = true;
                }
            }
        }
    }

    public int findCircleNum_unionFind(int[][] isConnected) {
        int res = isConnected.length;
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int r = 0; r < isConnected.length; r++) {
            for (int c = 0; c < isConnected[r].length; c++) {
                if (isConnected[r][c] == 1 && unionFind.find(r) != unionFind.find(c)) {
                    unionFind.union(r, c);
                    res--;
                }
            }
        }
        return res;
    }

    class UnionFind {

        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (x != parent[x]) x = parent[x];
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int res = new NumberOfProvinces().findCircleNum(
            new int[][] {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
            }
        );
        System.out.println(res);

        int res2 = new NumberOfProvinces().findCircleNum(
                new int[][] {
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}
                }
        );
        System.out.println(res2);
    }

}
