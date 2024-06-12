package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">...</a>
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {

    /**
     * Time Complexity: O(n) size of nums array
     * Space Complexity: O(n) size of nums array, based on constraint within problem statement
     * @param nums
     * @return
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int c: nums) {
            // Also match 0 at the beginning
            if (count[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(count[c]).add(c);
            count[c]++;
        }
        return ans;
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ConvertAnArrayIntoA2DArrayWithConditions().findMatrix(
                new int[]{1, 3, 4, 1, 2, 3, 1}
        );

        System.out.println(matrix);
    }

}
