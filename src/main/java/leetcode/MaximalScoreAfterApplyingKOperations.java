package leetcode;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximal-score-after-applying-k-operations/">Maximal Score After Applying K Operations</a>
 *
 */
public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n: nums) {
            pq.offer(n);
        }
        long sum = 0L;
        while (k > 0) {
            int largest = pq.poll();
            sum += largest;
            pq.offer((int) Math.ceil(largest / 3.0));
            k--;
        }
        return sum;
    }

}
