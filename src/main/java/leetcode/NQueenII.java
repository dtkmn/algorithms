package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">...</a>
 */
public class NQueenII {

    private List<List<int[]>> solutions = new ArrayList<>();
    private int count = 0;
    private int n;
    public int totalNQueens(int n) {
        this.n = n;

        rowOccupied = new boolean[n];
        colOccupied = new boolean[n];
        leftDiagonals = new boolean[n * 2];
        rightDiagonals = new boolean[n * 2];

        int row = 0;
        while (row < n)
            backtrack(row++, new ArrayList<>(), 0);
        return count;
    }

    public void backtrack(int row, List<int[]> localSolution, int localCount) {
        if (localCount == n) {
            solutions.add(localSolution);
            count++;
            return;
        }

        if (row >= n) return;

        for (int i = 0; i < n; i++) {
            if (validPos(row, i)) {
                // Add queen
                rowOccupied[row] = true;
                colOccupied[i] = true;
                leftDiagonals[row + i] = true;
                rightDiagonals[row - i + n] = true;
                localCount++;
                localSolution.add(new int[] {row, i});

                backtrack(row + 1, localSolution, localCount);

                // Remove queen
                rowOccupied[row] = false;
                colOccupied[i] = false;
                leftDiagonals[row + i] = false;
                rightDiagonals[row - i + n] = false;
                localCount--;
                localSolution.remove(localSolution.size() - 1);
            }

            if (row == n - 1 && i == n - 1) {
                System.out.println("we are in last element under n x n");
            }
        }
    }

    private boolean[] rowOccupied;
    private boolean[] colOccupied;
    private boolean[] leftDiagonals;
    private boolean[] rightDiagonals;

    public boolean validPos(int row, int col) {
        return !rowOccupied[row] && !colOccupied[col] && !leftDiagonals[row + col] && !rightDiagonals[row - col + n];
    }

    public static void main(String[] args) {
        System.out.println(
            new NQueenII().totalNQueens(4)
        );
    }

}
