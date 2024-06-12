package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">...</a>
 *
 */

public class NumberOfLongestIncreasingSubsequence {
//    private int[] dp;
//    private int[] countList;
//    public int findNumberOfLIS_slow(int[] nums) {
//        countList = new int[nums.length + 1];
//        dp = new int[nums.length];
//        dp[0] = 1;
//        int longest = schedule(-1, 0, 0, nums);
//        System.out.println(Arrays.toString(countList));
//        return countList[longest];
//    }
//
//    public int schedule(int prevIndex, int currentIndex, int count, int[] nums) {
//        if (currentIndex == nums.length) {
//            countList[count]++;
//            return count;
//        }
//
//        int skipCount = schedule(prevIndex, currentIndex + 1, count, nums);
//        int scheduleCount = 0;
//        if (prevIndex == -1) {
//            scheduleCount = schedule(currentIndex, currentIndex + 1, count + 1, nums);
//        } else if (nums[currentIndex] > nums[prevIndex]) {
//            scheduleCount = schedule(currentIndex, currentIndex + 1, count + 1, nums);
//        }
//
//        dp[currentIndex] = Math.max(skipCount, scheduleCount);
////        System.out.println("CurrentIndex -> " + currentIndex + " Count -> " + skipCount + ":" + scheduleCount);
////        if (currentIndex == nums.length - 1) countList[Math.max(skipCount, scheduleCount)]++;
//        return dp[currentIndex];
//    }

    public int findNumberOfLIS(int[] nums) {
        int[] count = new int[nums.length + 1];
        int[] length = new int[nums.length];
        length[0] = 1;
        count[0] = 1;
        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            int localLength = 1;
            int localCount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int plusLength = 1 + length[j];
                    if (plusLength > localLength) {
                        localLength = plusLength;
                        localCount = 1;
                    } else {
                        localCount++;
                    }
                }
            }
            count[i] = localCount;
            length[i] = localLength;
            longest = Math.max(longest, length[i]);
        }
//        System.out.println(longest);
        System.out.println(Arrays.toString(length));
        System.out.println(Arrays.toString(count));
        if (count[longest] == 1) return nums.length;
        return count[longest];
    }

    public static void main(String[] args) {

        System.out.println(
                new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 1,3,2,4 })
        );
        System.out.println();

        System.out.println(
            new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 1,3,5,4,7 })
        );
        System.out.println();
//
//        System.out.println(
//                new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 1,3,5,7,9 })
//        );
//        System.out.println();
//
        System.out.println(
            new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 2,2,2,2,2 })
        );
        System.out.println();

//        System.out.println(
//                new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[] { -8,28,68,-54,96,97,84,-32,8,-87,1,-7,-20,12,22 })
//        );
//        System.out.println();
    }

}
