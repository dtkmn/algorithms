package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/description/">...</a>
 */
public class PermutationsII {


    private List<List<Integer>> ans;
    private Set<String> pset = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        backtrack(0, nums);
        return ans;
    }


    public void backtrack(int pos, int[] nums) {
        if (pos == nums.length - 1) {
            List<Integer> localList = new ArrayList<>();
            for (int n: nums) {
                localList.add(n);
            }
            ans.add(localList);
            pset.add(Arrays.toString(nums));
            return;
        }

        if (pset.contains(Arrays.toString(nums))) return;
        for (int i = pos; i < nums.length; i++) {
            if (pos != i && nums[pos] == nums[i]) continue;
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
            backtrack(pos + 1, nums);
            temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new PermutationsII().permuteUnique(new int[] {
               2,2,1,1
            })
        );
    }

}
