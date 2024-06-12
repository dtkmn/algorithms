package leetcode;


import java.util.Stack;

/*
    https://leetcode.com/problems/dice-roll-simulation/
 */
public class DiceRollSimulation {

    private int n;
    private int ans;
//    public int dieSimulator(int n, int[] rollMax) {
//        this.n = n;
//        backtrack(-1, 0, n, rollMax.clone());
//        return ans;
//    }
//
//    public void backtrack(int prev, int time, int pos, int[] localRollMax) {
//        if (pos == 0) {
//            ans++;
//            return;
//        }
//        for (int i = 0; i < localRollMax.length; i++) {
//            int newTime = (i == prev)? time + 1: 1;
//            if (newTime > localRollMax[i]) continue;
//            backtrack(i, newTime,pos - 1, localRollMax);
////            localRollMax[i]++;
//        }
//    }

    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n+1][7];
        int[] time = new int[7];
        for (int i = 1; i < 7; i++) {
            dp[1][i] = 1;
            time[i] = 1;
        }

        for (int j = 2; j <= n; j++) {
            for (int m = 1; m <= 6; m++) {
                int count = 0;
                for (int k = 1; k <= 6; k++) {
                    if (k == m) {
                        if (time[k] < rollMax[k-1]) {
                            count += dp[j - 1][k];
                            time[k]++;
                        } else {
                            time[k] = 0;
                        }
                    } else {
                        count += dp[j - 1][k];
                    }

                }
                dp[j][m] = count;
            }
        }

        int res = 0;
        for (int item: dp[n]) {
            res += item;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
            new DiceRollSimulation().dieSimulator(3, new int[] {1,1,2,2,2,3})
        );
//        System.out.println(
//            new DiceRollSimulation().dieSimulator(3, new int[] {1,1,1,2,2,3})
//        );
    }
}
