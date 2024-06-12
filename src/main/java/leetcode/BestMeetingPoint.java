package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/best-meeting-point/">...</a>
 */

public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        // Create new median array to store the median value on each row
        int distance = 0;
        List<Integer> onesForRow = new ArrayList<>();
        List<Integer> onesForCol = new ArrayList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    onesForRow.add(r);
                }
            }
        }

        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == 1) {
                    onesForCol.add(c);
                }
            }
        }

        distance += getDistanceByMedian(onesForRow);
        distance += getDistanceByMedian(onesForCol);

        return distance;
    }

    private int getDistanceByMedian(List<Integer> list) {
        int median = list.get(list.size() / 2);
        int d = 0;
        for (int item : list) {
            d += Math.abs(median - item);
        }
        return d;
    }

    public static void main(String[] args) {
        int d = new BestMeetingPoint().minTotalDistance(
            new int[][] {
                { 1,0,0,0,1 },
                { 0,0,0,0,0 },
                { 0,0,1,0,0 }
            }
        );
        System.out.println(d);
    }
}
