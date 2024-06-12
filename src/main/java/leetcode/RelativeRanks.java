package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/relative-ranks/">...</a>
 *
 */

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[] { i, score[i] });
        }
        String[] ans = new String[score.length];
        int rank = -1;
        while (!pq.isEmpty()) {
            rank++;
            int[] cur = pq.poll();
            if (rank == 0) ans[cur[0]] = "Gold Medal";
            else if (rank == 1) ans[cur[0]] = "Silver Medal";
            else if (rank == 2) ans[cur[0]] = "Bronze Medal";
            else ans[cur[0]] = String.valueOf(rank+1);
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
