package leetcode;


/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static int maxSubArray_bf(int[] nums) {
        int max = Integer.MIN_VALUE , sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int maxSubArray_linear(int[] nums) {
        int maxSum = 0, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) currSum = maxSum = nums[0];
            else {
                currSum = currSum + nums[i];
                if (currSum > maxSum) maxSum = currSum;
                if (currSum < nums[i]) currSum = nums[i];
                if (nums[i] > maxSum) maxSum = nums[i];
            }
        }
        return maxSum;
    }

    // Kadane's algorithm approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int maxSubArray_linear_v2(int[] nums) {
        int maxSum = 0, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) currSum = maxSum = nums[0];
            else {
                currSum = Math.max(nums[i], nums[i] + currSum);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        System.out.println(
//            maxSubArray_bf(new int[] {-2,1,-3,4,-1,2,1,-5,4})
//        );
//        System.out.println(
//            maxSubArray_bf(new int[] {1})
//        );
        System.out.println(
            maxSubArray_linear_v2(new int[] {-2,1,-3,4,-1,2,1,-5,4})
        );
    }

}
