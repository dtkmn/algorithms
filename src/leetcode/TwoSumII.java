package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 */
public class TwoSumII {

    // Using Two pointer approach, remember it supposes the array already sorted
    // otherwise Time Complexity become O(nlogn) which include sorting
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int localSum = numbers[start] + numbers[end];
            if (localSum == target) {
                return new int[] {start + 1, end + 1};
            } else if (localSum >= target) {
                end--;
            } else start++;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
    }

}
