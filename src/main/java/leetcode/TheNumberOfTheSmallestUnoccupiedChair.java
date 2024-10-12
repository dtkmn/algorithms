package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair">The Number of the Smallest Unoccupied Chair</a>
 */
public class TheNumberOfTheSmallestUnoccupiedChair {

    public int smallestChair(int[][] times, int targetFriend) {
        int currentEmptyChair = 0;
        // each arrival time is distinct
        int target = times[targetFriend][0];
        // int[] {leave, chair}
        PriorityQueue<int[]> leavings = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> usedChairsAvailable = new PriorityQueue<>();

        // sort by arrival time
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        int time = times[0][0];
        int arrStart = 0;

        while (true) {
            while (!leavings.isEmpty() && time >= leavings.peek()[0]) {
                int[] poll = leavings.poll();
                int chair = poll[1];
                usedChairsAvailable.add(chair);
            }
            while (time >= times[arrStart][0]) {
                if (!usedChairsAvailable.isEmpty()) {
                    int chair =usedChairsAvailable.poll();
                    if (times[arrStart][0] == target) {
                        return chair;
                    }
                    leavings.add(new int[] { times[arrStart++][1], chair });
                } else {
                    if (times[arrStart][0] == target) {
                        return currentEmptyChair;
                    }
                    leavings.add(new int[] { times[arrStart++][1], currentEmptyChair++ });
                }
            }
            time++;
        }
    }

}
