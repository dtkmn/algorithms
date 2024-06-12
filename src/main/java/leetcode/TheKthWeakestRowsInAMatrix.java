package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">...</a>
 */
public class TheKthWeakestRowsInAMatrix {

    public static int[] kWeakestRows(int[][] mat, int k) {

//        int[] countMap = new int[mat.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int row = 0; row < mat.length; row++) {
//            int count = 0;
            // Finding the first 0, it is O(n) linear time atm
//            for (int col = 0; col < mat[row].length; col++) {
//                if (mat[row][col] == 0) break;
//                count += mat[row][col];
//            }
            int count = countOne(mat[row]);
            pq.offer(new int[]{row,count});
        }

        int[] answers = new int[k];
        for (int i = 0; i < k; i++) {
            answers[i] = pq.poll()[0];
        }
        return answers;
    }

    public static int countOne(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == 1) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
            {1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(kWeakestRows(input, 3)));
    }

}
