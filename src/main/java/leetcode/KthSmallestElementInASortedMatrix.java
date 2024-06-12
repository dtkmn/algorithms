package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">...</a>
 */
public class KthSmallestElementInASortedMatrix {

    private PriorityQueue<Integer> heap;
    private int k;
    private int heapSize;
    public KthSmallestElementInASortedMatrix() {
        this.heap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
    }

    public int kthSmallest(int[][] matrix, int k) {
        int monitorRows = Math.min(matrix.length, k);
        int heapSize = 0;
        for (int row = 0; row < monitorRows; row++) {
            for (int item: matrix[row]) {
                if (heapSize < k) {
                    heap.offer(item);
                    heapSize++;
                } else {
                    if (heap.peek() > item) {
                        heap.poll();
                        heap.offer(item);
                    } else break;
                }
            }
        }
        return heap.peek();
    }


    public int kthSmallestWithBS(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int len = matrix.length;
        if (k == len * len) return matrix[matrix.length - 1][matrix[0].length - 1];

        int monitorRows = Math.min(matrix.length, k);
        // Start with top left and bottom right extreme values
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];


        while (lo < hi) {
            int lessThanMid = lo, largerThanMid = hi;
            int mid = lo + (hi - lo) / 2;
            // Counting how many values less than current mid
            int count = 0, startCol = 0, startRow = monitorRows - 1;

            while (startRow >= 0 && startCol < matrix[0].length) {
                if (matrix[startRow][startCol] <= mid) {
                    // Get the max value below current mid
                    lessThanMid = Math.max(lessThanMid, matrix[startRow][startCol]);
                    count += (startRow + 1);
                    startCol++;
                } else {
                    // Get the min value above current mid
                    largerThanMid = Math.min(largerThanMid, matrix[startRow][startCol]);
                    startRow--;
                }
            }

            if (count == k) return lessThanMid;
            // when more elements are found than expected, we can make the mid lower on next
            // so hi can be lower
            if (count > k) hi = hi == largerThanMid? mid: largerThanMid;
            else {
                lo = lo == lessThanMid? mid: lessThanMid;
            }
        }
        return lo;
    }

    public int count(int[][] matrix, int middle, int startRow) {
        // Count values smaller than middle
        int count = 0, col = 0;
        while (startRow >= 0 && col < matrix[0].length) {
            if (matrix[startRow][col] <= middle) {

                count += (startRow + 1);
                col++;
            } else startRow--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallestWithBS(
                new int[][]{
                        {1,2},
                        {3,3}
                },
                3
        ));

//        new int[][]{
//                {1,2},
//                {1,3}
//        },

//        int[][] matrix = {
//            {1,5,9},
//            {10,11,13},
//            {12,13,15}
//        };
//        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, 8));


    }

}
