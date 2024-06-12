package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">...</a>
 */
public class LetterCombinationsOfAPhoneNumber {

    private Map<String, String> mapping = new HashMap<>();

    public LetterCombinationsOfAPhoneNumber() {
        mapping.put("2", "abc");
        mapping.put("3", "def");
        mapping.put("4", "ghi");
        mapping.put("5", "jkl");
        mapping.put("6", "mno");
        mapping.put("7", "pqrs");
        mapping.put("8", "tuv");
        mapping.put("9", "wxyz");
    }

    private List<String> ans;
    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        ans = new ArrayList<>();
        backtrack(0, new StringBuilder(), digits);
        return ans;
    }

    public void backtrack(int pos, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String comb = mapping.get(String.valueOf(digits.charAt(pos)));
        for (char c: comb.toCharArray()) {
            sb.append(c);
            backtrack(pos + 1, new StringBuilder(sb), digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new LetterCombinationsOfAPhoneNumber().letterCombinations("23")
        );
    }

}
