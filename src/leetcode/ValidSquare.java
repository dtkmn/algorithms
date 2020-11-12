package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-square/
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        // Put all the points into one single array
        int[][] pts = new int[][] { p1, p2, p3, p4 };

        // Sort the points based on x coordinates, using y coordinates if equals
        Arrays.sort(pts, (pt1, pt2) -> (pt1[0] == pt2[0]) ? pt1[1] - pt2[1] : pt1[0] - pt2[0]);

        // Calculate the single side
        double length = dist(pts[0], pts[1]);

        // Check the side length
        if (length == 0 || length != dist(pts[1], pts[3]) || length != dist(pts[0], pts[2]) || length != dist(pts[2], pts[3]))
            return false;

        // Calculate the diagonal
        if (dist(pts[1], pts[2]) != dist(pts[0], pts[3])) return false;

        return true;

    }

    private double dist(int[] pt1, int[] pt2) {
        // Without doing square root
        return (pt1[0] - pt2[0]) * (pt1[0] - pt2[0]) + (pt1[1] - pt2[1]) * (pt1[1] - pt2[1]);
    }


    public static void main(String[] args) {

    }

}
