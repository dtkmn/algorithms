package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/russian-doll-envelopes/">...</a>
 *
 */

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        // Envelopes based on width and height
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) return e1[1] - e2[1];
            return e1[0] - e2[0];
        });
        int ans = 0;
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        // Envelopes based on width and height
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) return e2[1] - e1[1];
            return e1[0] - e2[0];
        });

        List<int[]> seq = new ArrayList<>();
        seq.add(envelopes[0]);
        for (int i = 1; i < envelopes.length; i++) {
            int[] last = seq.getLast();
            if (envelopes[i][0] > last[0] && envelopes[i][1] > last[1]) {
                seq.add(envelopes[i]);
            } else {
                //TODO: Binary search instead of linear search
                for (int j = 0; j < seq.size(); j++) {
                    int[] temp = seq.get(j);
                    if (temp[0] >= envelopes[i][0] && temp[1] >= envelopes[i][1]) {
                        seq.set(j, envelopes[i]);
                        break;
                    }
                }
            }
        }
        return seq.size();
    }

    public static void main(String[] args) {
        int envelopes = new RussianDollEnvelopes().maxEnvelopes2(new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        });
        System.out.println(envelopes);
        int envelopes2 = new RussianDollEnvelopes().maxEnvelopes2(new int[][]{
                {1,1},
                {1,1},
                {1,1}
        });
    }

}
