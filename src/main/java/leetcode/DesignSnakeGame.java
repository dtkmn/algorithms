package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/combinations/">...</a>
 */
public class DesignSnakeGame {
    private int[] currentPos;
    private int width;
    private int height;
    private int foodIndex;
    private int[][] food;
    private int score = 0;
    private Queue<int[]> q = new LinkedList<>();
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        int foodIndex = 0;
        currentPos = new int[] {0,0};
    }

    private boolean eatFood(int row, int col) {
        if (foodIndex >= food.length) return true;
        int[] f = food[foodIndex];
        if (row == f[0] && col == f[1]) {
            foodIndex++;
            score++;
            return true;
        }
        return false;
    }

    private boolean kickItself(int row, int col) {
        for (int[] pos: q) {
            if (pos[0] == row && pos[1] == col) return true;
        }
        if (q.isEmpty() || q.size() < score) q.offer(new int[]{row,col});
        else {
            q.poll();
            q.offer(new int[]{row,col});
        }
        return false;
    }

    public int move(String direction) {
        switch (direction) {
            case "U" -> {
                int newRow = currentPos[0] - 1;
                if (newRow < 0) return -1;
                if (kickItself(newRow, currentPos[1])) return -1;
                currentPos[0] = newRow;
                if (eatFood(newRow, currentPos[1])) return foodIndex;
            }
            case "R" -> {
                int newCol = currentPos[1] + 1;
                if (newCol == width) return -1;
                if (kickItself(currentPos[0], newCol)) return -1;
                currentPos[1] = newCol;
                if (eatFood(currentPos[0], newCol)) return foodIndex;
            }
            case "D" -> {
                int newRow = currentPos[0] + 1;
                if (newRow == height) return -1;
                if (kickItself(newRow, currentPos[1])) return -1;
                currentPos[0] = newRow;
                if (eatFood(newRow, currentPos[1])) return foodIndex;
            }
            case "L" -> {
                int newCol = currentPos[1] - 1;
                if (newCol < 0) return -1;
                if (kickItself(currentPos[0], newCol)) return -1;
                currentPos[1] = newCol;
                if (eatFood(currentPos[0], newCol)) return foodIndex;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        DesignSnakeGame game = new DesignSnakeGame(3, 2,
                new int[][]{
                        {3, 2},
                        {1, 2},
                        {0, 1}
                });
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("U"));
    }

}
