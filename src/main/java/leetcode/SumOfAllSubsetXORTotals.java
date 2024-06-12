package leetcode;

/**
 * <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/">...</a>
 *
 s */

public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, i, 0);
        }
        return sum;
    }

    int sum = 0;

    void backtrack(int[] nums, int pos, int current) {
        if (pos == nums.length) {
            return;
        }
        int newCurr = (current ^ nums[pos]);
        sum += newCurr;
        for (int i = pos + 1; i < nums.length; i++) {
            backtrack(nums, i, newCurr);
        }

    }

    public static void main(String[] args) {
        int xorSum = new SumOfAllSubsetXORTotals().subsetXORSum(new int[]{
                1, 3
        });
        System.out.println("Ans: " + xorSum);
    }

}
