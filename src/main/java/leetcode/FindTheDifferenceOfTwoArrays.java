package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">...</a>
 */
public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums2) {
            set2.add(num);
        }
        List<Integer> onlyInFirst = new ArrayList<>();
        for (int value : set1) {
            if (!set2.contains(value)) onlyInFirst.add(value);
        }
        List<Integer> onlyInSecond = new ArrayList<>();
        for (int value : set2) {
            if (!set1.contains(value)) onlyInSecond.add(value);
        }

        return List.of(onlyInFirst, onlyInSecond);
    }

    public static void main(String[] args) {

    }

}
