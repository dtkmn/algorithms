package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">...</a>
 *
 */

public class LongestIncreasingSubsequenceII {
    public int lengthOfLIS(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int last = list.get(list.size() - 1);
            if (current == last) continue;
            if (last < current ) {
                if (current - last <= k) list.add(current);
                else list.set(list.size() - 1, nums[i]);
            } else {
                for (int j = 0; j < i; j++) {
                    if (list.get(j) >= current) {
                        list.set(j, current);
                        break;
                    }
                }
                System.out.println(list);
            }
        }
        return list.size();
    }


    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[] { 10,9,2,5,3,7,101,18 }));
//        System.out.println(lengthOfLIS(new int[] { 1,3,6,7,9,4,10,5,6 }));
//        System.out.println(lengthOfLIS(new int[] { 0,1,0,3,2,3 }));

//        System.out.println(
//            new LongestIncreasingSubsequence().lengthOfLISv2(new int[] { 10,9,2,5,3,7,101,18 })
//        );
//        System.out.println(
//            new LongestIncreasingSubsequence().lengthOfLISv2(new int[] { 0,1,0,3,2,3 })
//        );
        System.out.println(
            new LongestIncreasingSubsequenceII().lengthOfLIS(new int[] { 1,3,3,4 }, 1)
        );
    }

}
