package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 *
 */
public class IntervalListIntersections {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    // 3ms
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int aStart = 0, aEnd = A.length - 1;
        int bStart = 0, bEnd = B.length - 1;

        List<int[]> result = new ArrayList<>();
        while (aStart <= aEnd && bStart <= bEnd) {
//            if (A[aStart][0] <= B[bStart][0]) {
//                // eg. A = [1, 4], B = [3, 6]
//                if (A[aStart][1] >= B[bStart][0]) {
//                    result.add(new int[]{Math.max(A[aStart][0], B[bStart][0]), Math.min(A[aStart][1], B[bStart][1])});
//                }
//            } else {
//                if (B[bStart][1] >= A[aStart][0]) {
//                    result.add(new int[]{Math.max(A[aStart][0], B[bStart][0]), Math.min(A[aStart][1], B[bStart][1])});
//                }
//            }

            // The code can be tweaked as following 3 lines
            if (A[aStart][1] >= B[bStart][0] || B[bStart][1] >= A[aStart][0]) {
                result.add(new int[]{Math.max(A[aStart][0], B[bStart][0]), Math.min(A[aStart][1], B[bStart][1])});
            }

            if (A[aStart][1] < B[bStart][1]) aStart++;
            else bStart++;
        }
        return result.toArray(new int[result.size()][2]);

    }

    // educative.io
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int aStart = 0, aEnd = arr1.length - 1;
        int bStart = 0, bEnd = arr2.length - 1;

        while (aStart <= aEnd && bStart <= bEnd) {
            if (arr1[aStart].start <= arr2[bStart].start) {
                // eg. A = [1, 4], B = [3, 6]
                if (arr1[aStart].end >= arr2[bStart].start) {
                    intervalsIntersection.add(
                            new Interval(
                                Math.max(arr1[aStart].start, arr2[bStart].start),
                                Math.min(arr1[aStart].end, arr2[bStart].end)
                            )
                    );
                }
            } else {
                if (arr2[bStart].end >= arr1[aStart].start) {
                    intervalsIntersection.add(
                            new Interval(
                                    Math.max(arr1[aStart].start, arr2[bStart].start),
                                    Math.min(arr1[aStart].end, arr2[bStart].end)
                            )
                    );
                }
            }
            if (arr1[aStart].end < arr2[bStart].end) aStart++;
            else bStart++;
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(time);

        // [[1, 3], [4, 7], [8, 12]]
//        System.out.println(
//                Arrays.deepToString(intervalIntersection(new int[][]{
//                        {0, 2},
//                        {5, 10},
//                        {13, 23},
//                        {24, 25}
//                }, new int[][]{
//                        {1, 5},
//                        {8, 12},
//                        {15, 24},
//                        {25, 26}
//                })));

        System.out.println(
                Arrays.deepToString(intervalIntersection(new int[][]{
                        {8, 15}
                }, new int[][]{
                        {2, 6},
                        {8, 10},
                        {12, 20}
                })));


    }

}
