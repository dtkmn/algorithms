package practices;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationsBackTrackPractices {

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



    public void generateByZeroAndOne(int k, List<Integer> currentList, List<List<Integer>> answer) {
        if (currentList.size() == k) {
            answer.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            currentList.add(i);
            System.out.println(currentList);
            generateByZeroAndOne(k, currentList, answer);
            currentList.removeLast();
        }
    }

    public void generateByABC(char[] input, int pos, int k, List<Character> currentList, List<List<Character>> answer) {
        if (pos == input.length) {
            List<Character> p = new ArrayList<>();
            for (char c: input) p.add(c);
            answer.add(p);
            return;
        }
        for (int i = pos; i < input.length; i++) {
//            currentList.add(input[i]);
//            System.out.println(currentList);
//            int newPos = (pos + 1) % input.length;
//            if (!currentList.contains(input[newPos]))
            char temp = input[i];
            input[i] = input[pos];
            input[pos] = temp;
            System.out.println(input);
            generateByABC(input, pos + 1, k, currentList, answer);
            temp = input[i];
            input[i] = input[pos];
            input[pos] = temp;
//            currentList.removeLast();
        }
    }
    public static void main(String[] args) {
//        System.out.println(
//            new CombinationsBackTrackPractices().combine(3, 2)
//        );

        List<List<Character>> ans = new ArrayList<>();
        char[] input = new char[]{'a','b','c'};
        new CombinationsBackTrackPractices().generateByABC(new char[]{'a','b','c'}, 0, 3, new ArrayList<>(), ans);
        System.out.println(ans);

    }

}
