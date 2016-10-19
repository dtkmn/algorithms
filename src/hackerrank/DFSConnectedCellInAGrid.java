package hackerrank;

import java.util.Scanner;

public class DFSConnectedCellInAGrid {

    static int getBiggestRegion(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int m = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                max = 0;
                DFSsearch(matrix, visited, i, j, matrix.length, matrix[i].length);
                m = Math.max(max, m);
            }
        }
        return m;
    }

    static void DFSsearch(int[][] matrix, boolean[][] visited, int i, int j, int n, int m) {
        if (matrix[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            max++;
            if (i + 1 < n && j + 1 < m)
                DFSsearch(matrix, visited, i + 1, j + 1, n, m);
            if (i + 1 < n)
                DFSsearch(matrix, visited, i + 1, j, n, m);
            if (j + 1 < m)
                DFSsearch(matrix, visited, i, j + 1, n, m);
            if (i - 1 >= 0 && j + 1 < m)
                DFSsearch(matrix, visited, i - 1, j + 1, n, m);
            if (i - 1 >= 0)
                DFSsearch(matrix, visited, i - 1, j, n, m);
            if (i - 1 >= 0 && j - 1 >= 0)
                DFSsearch(matrix, visited, i - 1, j - 1, n, m);
            if (j - 1 >= 0)
                DFSsearch(matrix, visited, i, j - 1, n, m);
            if (i + 1 < n && j - 1 >= 0)
                DFSsearch(matrix, visited, i + 1, j - 1, n, m);
        }
    }

    static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

}
