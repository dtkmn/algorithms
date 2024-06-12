package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/arithmetic-subarrays/?envType=daily-question&envId=2023-11-23">...</a>
 */
public class ArithmeticSubarrays {

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] copied = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(copied);
            boolean arithmetic = true;
            int first = 0, second = first + 1;
            int diff = copied[second++] - copied[first++];
            while (second < copied.length) {
                if (copied[second++] - copied[first++] != diff) {
                    arithmetic = false;
                    break;
                }
            }
            ans.add(arithmetic);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
            checkArithmeticSubarrays(
                new int[]{4,6,5,9,3,7},
                new int[]{2},
                new int[]{5}
//                new int[]{0,0,2},
//                new int[]{2,3,5}
            )
        );
    }

}
