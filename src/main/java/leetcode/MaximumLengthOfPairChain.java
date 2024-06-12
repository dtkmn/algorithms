package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">...</a>
 *
 */

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < pairs.length; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            int[] last = list.get(list.size() - 1);
            if (last[1] < pairs[i][0]) {
                list.add(pairs[i]);
            } else {
                for (int[] t: list) {
                    System.out.println(t[0] + ": " + t[1]);
                }
                int index = bs(list, pairs[i]);
                list.set(index, pairs[i]);
//                 for (int j = 0; j < list.size(); j++) {
//                     int[] item = list.get(j);
//                     if (item[1] >= pairs[i][1]) {
//                         list.set(j, pairs[i]);
//                         break;
//                     }
//                 }
            }
//            System.out.println(list);
        }
        return list.size();
    }

    private int bs(List<int[]> list, int[] pair) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid)[1] == pair[1]) return mid;
            if (list.get(mid)[1] > pair[1]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }


    public static void main(String[] args) {
//        int longestChain = new MaximumLengthOfPairChain().findLongestChain(new int[][]{
//                {1, 2},
//                {2, 3},
//                {3, 4},
//        });
//        System.out.println(longestChain);
        int longestChain2 = new MaximumLengthOfPairChain().findLongestChain2(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
        });
        System.out.println(longestChain2);
    }

}
