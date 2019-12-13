package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        int pos1 = 0, pos2 = 0, outputIndex = 0;
        int count = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                output[outputIndex++] = nums1[pos1];
                pos1++; pos2++;
                count++;
            } else if (nums1[pos1] < nums2[pos2]) {
                pos1++;
            } else pos2++;
        }
        return Arrays.copyOf(output, count);
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(
                intersect(
                    new int[]{1,2,2,1},
                    new int[]{2,2}
                )
            )
        );
        System.out.println(
            Arrays.toString(
                intersect(
                    new int[]{4,9,5},
                    new int[]{9,4,9,8,4}
                )
            )
        );
    }

}
