package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums.length == 0) return result;

        // Time Complexity: O(NlogN) N == number of items in nums array
        Arrays.sort(nums);

        List<List<Integer>> lastList = new ArrayList<>();
        int preNum = Integer.MIN_VALUE;

        // Time Complexity: O(2 power N)
        for (int i: nums) {

            // Create new subset to store new items added on this step
            List<List<Integer>> currentList = new ArrayList<>();

            if (i != preNum) {

                // When current num not equal to previous value,
                // loop through the own list
                for (List<Integer> j : result) {
                    List<Integer> subset = new ArrayList<>(j);
                    subset.add(i);
                    currentList.add(subset);
                }

            } else {

                // When current num same as previous num,
                // loop through lastList instead
                for (List<Integer> j : lastList) {
                    List<Integer> subset = new ArrayList<>(j);
                    subset.add(i);
                    currentList.add(subset);
                }

            }

            lastList = currentList;
            result.addAll(currentList);
            preNum = i;

        }
        return result;

    }

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
        System.out.println(subsets(new int[] { 1, 2, 3, 3}));
        System.out.println();
        System.out.println(subsetsWithDup(new int[] { 1, 2, 3}));
        System.out.println(subsetsWithDup(new int[] { 1, 2, 3, 3}));
    }

}
