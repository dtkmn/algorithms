package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">...</a>
 *
 */
public class NumberOfIslands {


    // Time Complexity: O(MxN)
    // M: Number of rows, N: Number of columns
    public static int numIslands_dfs(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Island start from here
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }



    private static void dfs(char[][] grid, int row, int col) {
        // Make sure we won't have out of bound errors
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;
        // Set all the '1' from this point out to 4 directions to '0'
        if (grid[row][col] == '1') {
            // Set to '0' so won't visit again
            grid[row][col] = '0';
            dfs(grid,row + 1, col);
            dfs(grid,row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }

    public static int numIslands_bfs(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int num = 0;
        // Loop through the grid
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                // When it is equal to '1'
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    num++;
                    // Start going through the neighbours for current island
                    Queue<Integer> q = new LinkedList<>();
                    q.add(r * colLength + c);
                    // Put it in the queue and go through the grid around to visit
                    // all the 'nodes' within the same island
                    while (!q.isEmpty()) {
                        int p = q.poll();
                        int row = p / colLength;
                        int col = p % colLength;
                        if (row > 0 && grid[row - 1][col] == '1') {
                            q.add((row - 1) * colLength + col);
                            // Set it to 'zero' means 'visited' here
                            grid[row - 1][col] = '0';
                        }
                        if (col > 0 && grid[row][col - 1] == '1') {
                            q.add(row * colLength + (col - 1));
                            grid[row][col - 1] = '0';
                        }
                        if (row + 1 < rowLength && grid[row + 1][col] == '1') {
                            q.add((row + 1) * colLength + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col + 1 < colLength && grid[row][col + 1] == '1') {
                            q.add(row * colLength + (col + 1));
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num;

    }


    private class UnionFind {

        private int[] parent;
        private int[] rank;
        private int count;

        UnionFind(char[][] grid) {

            int rowLength = grid.length;
            int colLength = grid[0].length;

            /**
             *   0 1
             *   2 3
             *   4 5
             *
             *   0 1 2 3 4 5
             */
            parent = new int[rowLength * colLength];
            rank = new int[rowLength * colLength];
            for (int r = 0; r < rowLength; r++) {
                for (int c = 0; c < colLength; c++) {
                    if (grid[r][c] == '1') {
                        parent[r * colLength + c] = r * colLength + c;
                        count++; // plus 1 when it is equal to 1
                        rank[r * colLength + c] = 1;
                    }
                }
            }
        }

        int getCount() {
            return count;
        }

        int find(int p) {
            while (parent[p] != p) {
                p = parent[p];
            }
            return parent[p];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

    }

    public int numIslands_unionfind(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    System.out.println(r + ": " + c);
                    grid[r][c] = '0';
                    if (r > 0 && grid[r - 1][c] == '1') {
                        unionFind.union(r * colLength + c, (r - 1) * colLength + c);
                    }
                    if (r + 1 < rowLength && grid[r + 1][c] == '1') {
                        unionFind.union(r * colLength + c, (r + 1) * colLength + c);
                    }
                    if (c > 0 && grid[r][c - 1] == '1') {
                        unionFind.union(r * colLength + c, r * colLength + (c - 1));
                    }
                    if (c + 1 < colLength && grid[r][c + 1] == '1') {
                        unionFind.union(r * colLength + c, r * colLength + (c + 1));
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][] {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        }));

//        System.out.println(numIslands(new char[][] {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        }));

//        System.out.println(new NumberOfIslands().numIslands_unionfind(new char[][] {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        }));

        System.out.println(new NumberOfIslands().numIslands_unionfind(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }

}
