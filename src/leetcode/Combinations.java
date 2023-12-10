package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">...</a>
 */
public class Combinations {

    private int n;
    private int k;
    private List<List<Integer>> answer;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.answer = new ArrayList<>();
        backtrack(1, new ArrayList<>());
        return answer;
    }

    public void backtrack(int first, List<Integer> currentList) {
        if (currentList.size() == k) {
            answer.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = first; i <= n; i++) {
            currentList.add(i);
            backtrack(i + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new Combinations().combine(3, 2)
        );
    }

}
