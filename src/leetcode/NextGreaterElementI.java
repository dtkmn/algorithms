package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">...</a>
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> forNums2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            forNums2.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            int index = forNums2.get(curr);
            int j;
            for (j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > curr) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if (curr == nums1[i]) nums1[i] = -1;
        }
        return nums1;
    }

    public int[] nextGreaterElement_stack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                nextMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            nextMap.put(stack.pop(), -1);
        }

        for (int i = 0 ;i < nums1.length; i++) {
            nums1[i] = nextMap.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {

    }

}
