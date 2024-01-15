package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">...</a>
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] countWinner = new int[100001];
        int[] countLoser = new int[100001];
        for (int[] result: matches) {
            countWinner[result[0]]++;
            countLoser[result[1]]++;
        }
        List<Integer> allWin = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();
        for (int i = 0; i < countWinner.length; i++) {
            // Only count on player played at least once
            if (countWinner[i] > 0 || countLoser[i] > 0) {
                if (countLoser[i] == 0) {
                    allWin.add(i);
                } else if (countLoser[i] == 1) {
                    lostOnce.add(i);
                }
            }
        }
        return List.of(allWin, lostOnce);
    }

    public static void main(String[] args) {

    }

}
