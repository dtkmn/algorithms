package leetcode;

import java.util.Arrays;

public class SudokuSolver {
    // Total 9 boxes within Sudoku game

    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }

    private boolean checkPosition(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) return false;
            if (board[row][i] == value) return false;
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == value) return false;
        }
        return true;
    }

    public boolean backtrack(int row, int col, char[][] board) {
        if (row == board.length) {
            return true;
        }

        if (col == board[0].length) {
            return backtrack(row + 1, 0, board);
        }

        if (board[row][col] != '.') {
            return backtrack(row, col + 1, board);
        }

        if (board[row][col] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (!checkPosition(board, row, col, i)) continue;
                board[row][col] = i;
                if (backtrack(row, col + 1, board)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] input = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new SudokuSolver().solveSudoku(input);
        for (char[] i: input) {
            System.out.println(Arrays.toString(i));
        }
    }

}
