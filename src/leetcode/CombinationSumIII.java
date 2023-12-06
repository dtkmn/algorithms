package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/">...</a>
 */
public class CombinationSumIII {

    private List<List<Integer>> ans;
    private int combNum;
    private int target;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        this.combNum = k;
        this.target = n;
        backtrack(1, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int pos, List<Integer> currentList, int sum) {
        if (sum == this.target) {
            if (currentList.size() != this.combNum) return;
            ans.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = pos; i <= 9; i++) {
            if (i > this.target) break;
            if (sum + i > this.target || currentList.size() + 1 > combNum) break;

            currentList.add(i);
            sum += i;

            backtrack(i + 1, currentList, sum);

            sum -= i;
            currentList.remove(currentList.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(
            new CombinationSumIII().combinationSum3(3, 7)
        );
    }

}
