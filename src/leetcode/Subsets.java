package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 */
public class Subsets {


    // Time Complexity: O(2 POWER N)
    // Space Complexity: O(2 POWER N)
    public static List<List<Integer>> subsets(int[] nums) {

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

    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3}));
    }

}
