package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">...</a>
 */
public class CombinationSumII {

    private List<List<Integer>> ans;
//    private HashMap<String, Integer> mapping = new HashMap<>();
//    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        this.candidates = candidates;
        this.target = target;
        this.ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), 0, candidates);
        return this.ans;
    }

    public void backtrack(int pos, List<Integer> currentList, int sum, int[] candidates) {
        if (sum == this.target) {
//            System.out.println(currentList.toString());
            ans.add(new ArrayList<>(currentList));
//            if (!mapping.containsKey(currentList.toString())) {
//                ans.add(new ArrayList<>(currentList));
//                mapping.put(currentList.toString(), 1);
//            }
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] <= target) {
                sum += candidates[i];
                currentList.add(candidates[i]);
                backtrack(i + 1, currentList, sum, candidates);
                currentList.remove(currentList.size() - 1);
                sum -= candidates[i];
            } else break;

        }
    }

    public static void main(String[] args) {
        System.out.println(
            new CombinationSumII().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8)
        );
        System.out.println(
                new CombinationSumII().combinationSum2(new int[] {2,5,2,1,2}, 5)
        );
    }

}
