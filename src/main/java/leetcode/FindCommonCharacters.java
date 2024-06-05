package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-common-characters/">1002. Find Common Characters</a>
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int size = words.length;
        if (size == 0) return List.of();

        List<String> ans = new ArrayList<>();
        int[][] existed = new int[size][26];
        for (int i = 0; i < size; i++) {
            for (char c: words[i].toCharArray()) {
                existed[i][c-'a']++;
            }
        }
        int[] col = existed[0];
        for (int j = 0; j < col.length; j++) {
            int v = col[j];
            if (v > 0) {
                boolean pass = false;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < size; k++) {
                    if (existed[k][j] == 0) {
                        pass = true;
                        break;
                    } else {
                        min = Math.min(min, existed[k][j]);
                    }
                }
                if (!pass) {
                    for (int i = 0; i < min; i++) {
                        ans.add(String.valueOf((char)(j + 'a')));
                    }
                }
            }
        }
        return ans;
    }

}
