package leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 */
public class MeetingRoomsII {

    // educative.io
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    // 6ms
    public static int minMeetingRooms_priorityQueue(int[][] intervals) {
        if (intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println(Arrays.deepToString(intervals));

        int max = 0;
        // Priority Queue created to save the end time on each meeting
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>(intervals.length);
        for (int[] interval: intervals) {
            if (endTimeQueue.size() == 0) endTimeQueue.add(interval[1]);
            else {
                // When the room finishing soon has end time sooner than current interval start time
                while (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= interval[0])
                    endTimeQueue.poll();

                endTimeQueue.add(interval[1]);
                max = Math.max(max, endTimeQueue.size());
            }
        }

        return max;

    }

    // 2ms
    public static int minMeetingRooms_arrayOnly(int[][] intervals) {
        int size = intervals.length;
        if (size <= 1) return size;

        // Create 2 arrays for start and end time separately
        int[] startTime = new int[size];
        int[] endTime = new int[size];

        for (int i = 0; i < size; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int max = 0, roomSize = 0, endPointer = 0;
        for (int i = 0; i < size; i++) {
            // Nothing to process when room size is 0
            if (roomSize == 0) roomSize++;
            else {
                // Check current start time with already open rooms to update
                while (roomSize > 0 && endTime[endPointer] <= startTime[i]) {
                    roomSize--;
                    endPointer++;
                }
                // finally still need a room for current time
                roomSize++;
            }
            // Check and update the max if necessary
            max = Math.max(max, roomSize);
        }

        return max;

    }

    public static void main(String[] args) {

//        [[13,15],[1,13],[6,9]]
        System.out.println(
            minMeetingRooms_arrayOnly(
                new int[][]{
                    new int[]{13, 15},
                    new int[]{1, 13},
                    new int[]{6, 9}
                }
            )
        );

    }

}
