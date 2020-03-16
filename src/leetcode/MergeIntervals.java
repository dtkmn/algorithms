package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 */
public class MergeIntervals {

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 5ms
    public static int[][] merge_for_loop(int[][] intervals) {

        if (intervals.length == 0) return new int[][]{};

        // Sorting first
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> result = new ArrayList<>();
        int[] preArray = intervals[0];

        for (int[] interval: intervals) {
            int[] currentArray = interval;
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
        result.add(preArray);

        return result.toArray(new int[result.size()][2]);

    }

    // 5ms
    public static int[][] merge_while(int[][] intervals) {

        if (intervals.length == 0) return new int[][]{};

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

    // 5ms
    public static int[][] merge_array_only(int[][] intervals) {

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
                    intervals[i][0] = intervals[i][1]= -1;
                    currentSize--;
                } else preArray = currentArray;
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

    // 8ms
    public static int[][] merge(int[][] intervals) {

        // Sorting first
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // Put all items within array into new ArrayList ...
        List<Interval> intervalsList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalsList.add(new Interval(intervals[i][0], intervals[i][1]));
        }


        Iterator<Interval> iterator = intervalsList.iterator();
        Interval pre = null, current;
        while (iterator.hasNext()) {
            if (pre == null) {
                pre = iterator.next();
            } else {
                current = iterator.next();
                if (pre.end >= current.start) {
                    pre.end = Math.max(pre.end, current.end);
                    iterator.remove();
                } else pre = current;
            }
        }

        int[][] output = new int[intervalsList.size()][2];
        for (int i = 0; i < intervalsList.size(); i++) {
            Interval item = intervalsList.get(i);
            output[i][0] = item.start;
            output[i][1] = item.end;
        }
        return output;

    }

    // From educative.io
    public static List<Interval> merge(List<Interval> intervals) {

        // We sort the intervals list first based on the start
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval pre = null;
        Iterator<Interval> iterator = intervals.iterator();

        while (iterator.hasNext()) {
            if (pre == null) pre = iterator.next();
            else {
                Interval current = iterator.next();
                if (pre.end >= current.start) {
                    // merge
                    pre.end = Math.max(pre.end, current.end);
                    intervals.remove(current);
                } else pre = current;
            }
        }

        return intervals;

    }

    public static void main(String[] args) {
        System.currentTimeMillis();

        System.out.println(
                Arrays.deepToString(merge(new int[][]{
                        {1, 3},
                        {3, 7},
                        {2, 6}
                })));
        System.out.println(
                Arrays.deepToString(merge(new int[][]{
                        {1, 4},
                        {0, 2},
                        {3, 5}
                })));

        System.currentTimeMillis();
    }

}
