package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int value: nums) queue.add(value);
        // only remain k items in queue
        while (queue.size() > k) queue.poll();
    }

    public int add(int val) {
        // when current size equal to k and val smaller than peek()
        if (queue.size() == k && val <= queue.peek()) return queue.peek();
        // else we can add this new item
        queue.add(val);
        // in case when the size is just over k
        if (queue.size() > k) queue.poll();
        // k largest will be from the peek()
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[] {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }

}
