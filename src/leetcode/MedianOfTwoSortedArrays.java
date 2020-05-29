package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 */
public class MedianOfTwoSortedArrays {

    // 5ms
    // First approach using PriorityQueue
    // Time Complexity: O(M+N)
    // Space Complexity: O(M+N)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;
        int pqSize = size / 2 + 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(pqSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        int startNum1 = 0, startNum2 = 0;
        while (pq.size() < pqSize && (startNum1 < nums1.length || startNum2 < nums2.length)) {

            if (startNum1 == nums1.length) pq.add(nums2[startNum2++]);
            else if (startNum2 == nums2.length) pq.add(nums1[startNum1++]);
            else if (nums1[startNum1] <= nums2[startNum2]) {
                pq.add(nums1[startNum1++]);
            } else pq.add(nums2[startNum2++]);

        }


        if (size % 2 == 0) return (pq.poll() + pq.poll()) / 2.0;
        else return pq.poll() * 1.0;

    }

    // 2ms
    // Replace PriorityQueue with normal array instead, since 2 arrays are sorted
    // Time Complexity: O(M+N)
    // SPace Complexity: O((M+N)/2)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;

        // odd: (pqsize - 1)
        // even: ((pqsize - 1) + (pqsize - 2)) / 2
        int pqSize = size / 2 + 1;

        // Space Complexity: O(M+N)
        // Or just using variable to save the index to make it O(1)
        int[] result = new int[pqSize];

        int resultIndex = 0;
        int startNum1 = 0, startNum2 = 0;

        while (resultIndex < pqSize && (startNum1 < nums1.length || startNum2 < nums2.length)) {

            if (startNum1 == nums1.length) result[resultIndex++] = nums2[startNum2++];
            else if (startNum2 == nums2.length) result[resultIndex++] = nums1[startNum1++];
            else if (nums1[startNum1] <= nums2[startNum2]) {
                result[resultIndex++] = nums1[startNum1++];
            } else result[resultIndex++] = nums2[startNum2++];

        }

        // Median position depends on the size in total
        if (size % 2 == 0) return (result[pqSize - 1] + result[pqSize - 2]) / 2.0;
        else return result[pqSize - 1] * 1.0;

    }

    public static void main(String[] args) {

    }

}
