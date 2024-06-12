package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-queens/">...</a>
 */
public class NQueens {

    private int n;

    private boolean[] row;
    private boolean[] col;
    private boolean[] leftD;
    private boolean[] rightD;

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        row = new boolean[n];
        col = new boolean[n];
        leftD = new boolean[n * 2];
        rightD = new boolean[n * 2];

        int r = 0;
        while (r < n) {
            backtrack(r++, 0, new ArrayList<>());
        }
        return ans;
    }

    public boolean isValid(int r, int c) {
        if (row[r] || col[c] || leftD[r + c] || rightD[r - c + n]) return false;
        return true;
    }


    public void backtrack(int r, int localCount, List<String> currentList) {
        if (localCount == n) {
            ans.add(new ArrayList<>(currentList));
            return;
        }

        if (r >= n) return;

        for (int i = 0; i < n; i++) {
            if (isValid(r, i)) {
                row[r] = true;
                col[i] = true;
                leftD[r + i] = true;
                rightD[r - i + n] = true;
                localCount++;

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) sb.append("Q");
                    else sb.append(".");
                }
                currentList.add(sb.toString());

                backtrack(r + 1, localCount, currentList);

                row[r] = false;
                col[i] = false;
                leftD[r + i] = false;
                rightD[r - i + n] = false;
                localCount--;
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new NQueens().solveNQueens(4)
        );
//        List<List<int[]>> totalNQueens = new NQueenII().totalNQueens(4);
//
//        for (List<int[]> queen: totalNQueens) {
//            for (int[] q: queen) {
//                System.out.print(q[0] + ", " + q[1] + " | ");
//            }
//            System.out.println();
//        }
    }

}
