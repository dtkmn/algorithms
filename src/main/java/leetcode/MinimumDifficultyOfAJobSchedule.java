package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">...</a>
 *
 */

public class MinimumDifficultyOfAJobSchedule {

    private int d;
    private int[] jobDifficulty;
    public int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {

        if (jobDifficulty.length < d) return -1;

        this.d = d;
        this.jobDifficulty = jobDifficulty;
        this.dp = new int[jobDifficulty.length][d+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for (int j = jobDifficulty.length - 1; j >= 0; j--) {
            max = Math.max(max, jobDifficulty[j]);
            dp[j][d] = max;
        }

        return dfs_dp(1,0);
    }

    private int dfs_dp(int currentDay, int finishTask) {
        if (currentDay == d) {
            return dp[finishTask][d];
        }
        int totalTask = jobDifficulty.length;

        if (dp[finishTask][currentDay] != -1) return dp[finishTask][currentDay];

        int n = totalTask - (d - currentDay);

        int hardest = 0;
        int best = Integer.MAX_VALUE;
        for (int i = finishTask; i < n; i++) {
            hardest = Math.max(hardest, jobDifficulty[i]);
            best = Math.min(best, hardest + dfs_dp(currentDay + 1, i + 1));
        }
//        System.out.println("finish task: " + finishTask + ", current day: " + currentDay + ", best: " + best);
        dp[finishTask][currentDay] = best;
        return dp[finishTask][currentDay];
    }
    public static void main(String[] args) {

        MinimumDifficultyOfAJobSchedule jobSchedule = new MinimumDifficultyOfAJobSchedule();

//        System.out.println(
//            new MinimumDifficultyOfAJobSchedule().minDifficulty(
//                new int[] { 6,5,4,3,2,1 }, 2
//            )
//        );
//        System.out.println(
//                new MinimumDifficultyOfAJobSchedule().minDifficulty(
//                        new int[] { 1,1,1 }, 3
//                )
//        );

        System.out.println(
            jobSchedule.minDifficulty(
                new int[] { 11,111,22,222,33,333,44,444 }, 6
            )
        );

        System.out.println(
                jobSchedule.minDifficulty(
                new int[] { 6,5,10,3,2,1 }, 3
            )
        );
        int[][] dp = jobSchedule.dp;
        for (int[] d: dp) {
            System.out.println(Arrays.toString(d));
        }
    }

}
