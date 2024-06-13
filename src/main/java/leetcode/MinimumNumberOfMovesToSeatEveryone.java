package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/">2037. Minimum Number of Moves to Seat Everyone</a>
 */
public class MinimumNumberOfMovesToSeatEveryone {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

}
