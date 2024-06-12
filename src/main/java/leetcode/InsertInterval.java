package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 */
public class InsertInterval {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[newIntervals.length - 1] = newInterval;
        return merge_while(newIntervals);
    }

    // 1ms
    public static int[][] insert_nosort(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();

        int start = 0;
        final int end = intervals.length - 1;
        boolean intervalFilled = false;

        // Get the interval to be merged first
        while (start <= end) {
            int[] currentInterval = intervals[start];
            if (currentInterval[0] > newInterval[1]) {
                result.add(newInterval);
                intervalFilled = true;
                break;
            } else if (currentInterval[1] >= newInterval[0]) {
                currentInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
                intervalFilled = true;
                break;
            }
            else {
                result.add(currentInterval);
                start++;
            }
        }

        // Not able to fill in the interval after the loop above, must be placed at the end of result and return !
        if (!intervalFilled) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][2]);
        }

        // check and merge for the rest of intervals
        int[] preInterval = intervals[start];
        while (start <= end) {
            int[] currentArray = intervals[start];
            if (preInterval[1] >= currentArray[0]) {
                // merge
                preInterval[1] = Math.max(preInterval[1], currentArray[1]);
            } else {
                result.add(preInterval);
                preInterval = currentArray;
            }
            start++;
        }

        result.add(preInterval);

        return result.toArray(new int[result.size()][2]);

    }

    // educative.io
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (intervals.size() == 0) return Arrays.asList(newInterval);

        List<Interval> mergedIntervals = new ArrayList<>();

        int start = 0, end = intervals.size() - 1;

        boolean intervalFilled = false;
        while (start <= end) {
            Interval currentInterval = intervals.get(start);
            if (currentInterval.start > newInterval.end) {
                mergedIntervals.add(newInterval);
                intervalFilled = true;
                break;
            } else if (currentInterval.end >= newInterval.start) {
                currentInterval.start = Math.min(currentInterval.start, newInterval.start);
                currentInterval.end = Math.max(currentInterval.end, newInterval.end);
                intervalFilled = true;
                break;
            } else {
                mergedIntervals.add(currentInterval);
                start++;
            }
        }

        if (!intervalFilled) {
            mergedIntervals.add(newInterval);
            return mergedIntervals;
        }

        Interval preInterval = intervals.get(start);
        while (start <= end) {
            Interval currentArray = intervals.get(start);
            if (preInterval.end >= currentArray.start) {
                // merge
                preInterval.end = Math.max(preInterval.end, currentArray.end);
            } else {
                mergedIntervals.add(preInterval);
                preInterval = currentArray;
            }
            start++;
        }

        mergedIntervals.add(preInterval);

        return mergedIntervals;
    }

    // 3ms
    public static int[][] merge_while(int[][] intervals) {

        // Sorting first
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int start = 0, end = intervals.length - 1;
        int[] preArray = {-1, -1};
        List<int[]> result = new ArrayList<>();

        while (start <= end) {
            if (start == 0) preArray = intervals[start];
            else {
                int[] currentArray = intervals[start];
                // eg. [1, 3] and ( [2, 5] or [3, 6] or [1, 2])
                if (preArray[1] >= currentArray[0]) {
                    // merge
                    preArray[1] = Math.max(preArray[1], currentArray[1]);
                    // currentArray can be removed
                } else {
                    result.add(preArray);
                    preArray = currentArray;
                }
            }
            start++;
        }
        result.add(preArray);

        return result.toArray(new int[result.size()][2]);

    }

    public static int[][] merge_enhanced(int[][] intervals) {

        // Sorting first
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[] preArray = {-1, -1};
        int currentSize = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) preArray = intervals[i];
            else {
                int[] currentArray = intervals[i];
                if (preArray[1] >= currentArray[0]) {
                    // merge
                    preArray[1] = Math.max(preArray[1], currentArray[1]);
                    // Mark this interval as 'invalid'
                    intervals[i][0] = intervals[i][1]= -1;
                    currentSize--;
                } else {
                    preArray = currentArray;
                }
            }
        }
        int[][] output = new int[currentSize][2];
        int pos = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != -1 && intervals[i][1] != -1) {
                output[pos][0] = intervals[i][0];
                output[pos][1] = intervals[i][1];
                pos++;
            }
        }

        return output;
    }

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(time);

        // [[1, 3], [4, 7], [8, 12]]
        System.out.println(
                Arrays.deepToString(insert(new int[][]{
                        {1, 3},
                        {5, 7},
                        {8, 12}
                }, new int[]{4, 6})));

        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();

        // [[1, 10], [12, 16]]
        System.out.println(
                Arrays.deepToString(insert(new int[][]{
                        {1, 2},
                        {3, 5},
                        {6, 7},
                        {8, 10},
                        {12, 16}
                }, new int[]{4, 8})));

        System.out.println(System.currentTimeMillis() - time);

        System.out.println("----- insert_nosort -----");
        System.out.println(
                Arrays.deepToString(insert_nosort(new int[][]{
                        {1, 2},
                        {3, 5},
                        {6, 7},
                        {8, 10},
                        {12, 16}
                }, new int[]{4, 8})));

        System.out.println(
                Arrays.deepToString(insert_nosort(new int[][]{
                        {1, 3},
                        {6, 9}
                }, new int[]{2, 5})));

        System.out.println(
                Arrays.deepToString(insert_nosort(new int[][]{
                        {1, 5}
                }, new int[]{6, 8})));


    }

}
