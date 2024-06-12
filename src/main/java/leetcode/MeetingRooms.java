package leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/
 *
 */
public class MeetingRooms {

    private static int[] time = new int[10000];

    // Brute Force
    public static boolean canAttendMeetings(int[][] intervals) {
        for (int[] slot: intervals) {
            for (int i = slot[0]; i <= slot[1]; i++) {
                if (time[i] == 1 && (i != slot[0] && i != slot[1])) {
                    return false;
                }
                else time[i] = 1;
            }
        }
        return true;
    }

    // Sorting interval by start time
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean canAttendMeetings_sortStartTime(int[][] intervals) {

        // Time Complexity: O(NlogN)
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // Time Complexity: O(N)
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] < intervals[i+1][0]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
            canAttendMeetings_sortStartTime(
                new int[][]{
                    new int[]{13, 15},
                    new int[]{1, 13}
                }
            )
        );
    }

}
