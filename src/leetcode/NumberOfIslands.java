package leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 */
public class NumberOfIslands {


    // Time Complexity: O(MxN)
    // M: Number of rows, N: Number of columns
    public static int numIslands(char[][] grid) {

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

    public static void main(String[] args) {

//        System.out.println(numIslands(new char[][] {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        }));

        System.out.println(numIslands(new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        }));
    }

}
