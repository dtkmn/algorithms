package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">...</a>
 */
public class Permutations {

    private List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(0, nums);
        return ans;
    }

    public void dfs(List<Integer> list, List<Integer> flow) {
        if (flow.isEmpty()) {
            ans.add(list);
            return;
        }
        for (int i = 0; i < flow.size(); i++) {
            Integer i1 = flow.get(i);
            List<Integer> newList = new ArrayList<>(list);
            newList.add(i1);
            List<Integer> newLocal = new ArrayList<>(flow);
            newLocal.remove(i1);
            dfs(newList, newLocal);
        }
    }

    public void backtrack(int pos, int[] nums) {
        if (pos == nums.length) {
            List<Integer> localList = new ArrayList<>();
            for (int n: nums) localList.add(n);
            ans.add(localList);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
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
            new Permutations().permute(new int[] {
               1,2,3,4
            })
        );
    }

}
