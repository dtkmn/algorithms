package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    // 1st approach using sort and return the kth element from the end
    // Time complexity is O(NlogN), from Arrays sort
    // Space complexity is O(1), in place
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 2nd approach using heap
    // Time Complexity should improve to O(Nlogk)
    // O(log k) to add element to heap (k size)
    // Space Complexity is O(k), always keep k largest items in PQ
    public static int findKthLargest2nd(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // 3rd approach using QuickSelect
    public static int findKthLargest3rd(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int partition(int[] nums, int start, int end, int ksmall) {

        // Getting new pivot location
        int pivotLocation = pivot(nums, start, end);

        if (ksmall == pivotLocation) {
            return nums[ksmall];
        }
        if (ksmall > pivotLocation) {
            return partition(nums, pivotLocation + 1, end, ksmall);
        }
        return partition(nums, start, pivotLocation - 1, ksmall);
    }

    // Make sure the left side of pivot are all smaller, and bigger on right side
    // Time complexity: O(n) average, worst O(n2) .... when choosing first item as pivot or already sorted array. e.g.
    // Space complexity: O(1)
    private static int pivot(int[] nums, int start, int end) {

        // Using first item as pivot would cost 8ms :P
//        int pivot = nums[start];

        // Randomly choosing new pivot index instead become 1ms !!
//        Random random = new Random();
//        int pIndex = start + random.nextInt(end - start + 1);
//        int pivot = nums[pIndex];

        // We can choose the mid as pivot too... also 1ms
        int pIndex = start + (end - start) / 2;
        int pivot = nums[pIndex];

        // Put pivot to the end
        swap(pIndex, end, nums);

        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(storeIndex, i, nums);
                storeIndex++;
            }
        }

        // Put pivot on correct position
        swap(storeIndex, end, nums);

        return storeIndex;

    }

    private static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
//        int k = 2;
//        int[] arr = new int[] {3,2,1,5,6,4};
//        System.out.println(findKthLargest_3rd(arr, k));

        System.out.println(findKthLargest3rd(new int[] {1}, 1));
        System.out.println(findKthLargest3rd(new int[] {1,2}, 1));
    }

}
