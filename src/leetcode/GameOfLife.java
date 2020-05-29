package leetcode;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 */
public class GameOfLife {

    // 0ms
    // Time Complexity: O(MxN) M == rows of board, N = columns of board
    // Space Complexity: O(1)
    public void gameOfLife(int[][] board) {

        if (board.length == 0) return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {

                int count = 0;

                // Count live neighbours on every position (1, -1)
                if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1)) count++;
                if (i + 1 < board.length && (board[i + 1][j] == 1 || board[i + 1][j] == -1)) count++;
                if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1)) count++;
                if (j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == -1)) count++;
                if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1)) count++;
                if (i + 1 < board.length && j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1)) count++;
                if (i - 1 >= 0 && j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1)) count++;
                if (i + 1 < board.length && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1)) count++;

                if (board[i][j] == 1 || board[i][j] == -1) {
                    // Will die on next stage (Using -1)
                    if (count < 2) board[i][j] = -1;
                    if (count > 3) board[i][j] = -1;
                } else {
                    // Will become live (Using -2)
                    if (count == 3) board[i][j] = -2;
                }
            }
        }

        // Update the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }

    }

    public static void main(String[] args) {

    }

}
