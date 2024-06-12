package leetcode;


/**
 * <a href="https://leetcode.com/problems/island-perimeter/">...</a>
 *
 */
public class IslandPerimeter {

    // 5ms ~99+%
    // Time Complexity: O(MxN) Grid row x Grid col
    // Space Complexity: O(1)
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rl = grid.length;
        int cl = grid[0].length;
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    if (j == 0 || grid[i][j-1] == 0) perimeter++;
                    if (j + 1 >= cl || grid[i][j+1] == 0) perimeter++;
                    if (i + 1 >= rl || grid[i+1][j] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(
            islandPerimeter(
                new int[][]{
                    new int[]{0,1,0,0},
                    new int[]{1,1,1,0},
                    new int[]{0,1,0,0},
                    new int[]{1,1,0,0}
                }
            )
        );
    }

}
