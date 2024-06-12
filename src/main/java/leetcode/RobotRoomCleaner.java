package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 *
 * <a href="https://leetcode.com/problems/robot-room-cleaner/">...</a>
 *
 */
public class RobotRoomCleaner {

    class Robot {
        boolean move() {
            return true;
        }

        public void clean(){}
        public void turnLeft(){}
        public void turnRight(){}

    }
    private int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    private Set<String> visited;
    private Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.visited = new HashSet<>();
        backtrack(0, 0, 0);
    }

    public void backtrack(int row, int col, int dir) {
        visited.add(row + "->" + col);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4;
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (!visited.contains(newRow + "->" + newCol) && robot.move()) {
                // System.out.println("Working?");
                backtrack(newRow, newCol, newDir);
                // Going backward with only turning right and move
                back(robot);
            }
            // Next direction
            robot.turnRight();
        }
    }

    private void back(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public static void main(String[] args) {

    }

}
