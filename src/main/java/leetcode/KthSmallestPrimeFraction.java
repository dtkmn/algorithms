package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/">...</a>
 *
 s */

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> 1.0 * o[0] / o[1]));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.offer(new int[] {arr[i], arr[j]});
            }
        }
        int count = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (++count == k) return poll;
        }
        return new int[0];
    }

}
