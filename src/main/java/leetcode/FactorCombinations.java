package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/factor-combinations/">...</a>
 */
public class FactorCombinations {

    private List<List<Integer>> ans;

    public List<List<Integer>> getFactors(int n) {
        if (n <= 1) return List.of();
        ans = new ArrayList<>();
        backtrack(n, 2, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int n, int pos, List<Integer> currentList, int currentProduct) {
        if (currentProduct == n) {
            ans.add(new ArrayList<>(currentList));
            return;
        }
        for (int i=pos; i <= n / 2; i++) {
            if (currentProduct * i > n) break;
            if (n % i == 0) {
                currentList.add(i);
                backtrack(n, i, currentList, currentProduct * i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new FactorCombinations().getFactors(12)
        );
        System.out.println(
                new FactorCombinations().getFactors(92523)
        );
//        System.out.println(
//                new FactorCombinations().getFactors(7511016)
//        );
    }

}
