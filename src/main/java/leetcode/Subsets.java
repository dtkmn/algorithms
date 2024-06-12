package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">...</a>
 *
 */
public class Subsets {


    // Time Complexity: O(2 POWER N)
    // Space Complexity: O(2 POWER N)
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums.length == 0) return result;

        for (int i: nums) {

            // Create new subset and loop through each item
            // within result list
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> j: result) {
                List<Integer> subset = new ArrayList<>(j);
                subset.add(i);
                newList.add(subset);
            }

            for (List<Integer> addList: newList) {
                result.add(addList);
            }

        }
        return result;
    }


    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets_backtrack(int[] nums) {
        ans.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int pos, List<Integer> list) {
        if (pos == nums.length) return;
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            backtrack(nums, 1 + i, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[] { 1, 2, 3 }));
        System.out.println(new Subsets().subsets_backtrack(new int[] { 1, 2, 3 }));
    }

}
