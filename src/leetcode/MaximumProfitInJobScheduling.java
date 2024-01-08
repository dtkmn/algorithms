package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">...</a>
 *
 */

public class MaximumProfitInJobScheduling {

    class Job {
        int startTime;
        int endTime;
        int profit;
    }

    private List<Job> jobs;
    private int[] dp;

    /**
     * Time Complexity: O(NlogN) N is the size of total jobs given
     * Space Complexity: O(N)
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // First suppose startTime is sorted already....
        this.jobs = new ArrayList<>();
        this.dp = new int[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            Job j = new Job();
            j.startTime = startTime[i];
            j.endTime = endTime[i];
            j.profit = profit[i];
            jobs.add(j);
        }
        jobs.sort((j1, j2) -> {
            return j1.startTime - j2.startTime;
        });

        return schedule(0, 0);
    }
    public int schedule(int currentJobIndex, int currentProfit) {
        if (currentJobIndex == jobs.size()) {
            return currentProfit;
        }
        if (dp[currentJobIndex] != 0) {
            return dp[currentJobIndex];
        }
        // Skip this job
        int skipProfit = schedule(currentJobIndex + 1, currentProfit);
        // Schedule this job
        Job scheduleJob = jobs.get(currentJobIndex);
        int scheduleProfit = scheduleJob.profit + currentProfit;

        int next = searchNextJob(currentJobIndex + 1, scheduleJob.endTime);
        if (next != -1) {
            scheduleProfit += schedule(next, scheduleProfit);
        }
        dp[currentJobIndex] = Math.max(skipProfit, scheduleProfit);
        return dp[currentJobIndex];
    }

    public int searchNextJob(int fromIndex, int start) {
        int lo = fromIndex, hi = jobs.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs.get(mid).startTime >= start) {
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return lo == jobs.size()? -1: lo;
    }

    public static void main(String[] args) {
        int scheduling = new MaximumProfitInJobScheduling().jobScheduling(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70}
        );
        System.out.println(scheduling);

        int scheduling2 = new MaximumProfitInJobScheduling().jobScheduling(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60}
        );
        System.out.println(scheduling2);

        int scheduling3 = new MaximumProfitInJobScheduling().jobScheduling(
                new int[]{ 4,2,4,8,2 },
                new int[]{ 5,5,5,10,8 },
                new int[]{ 1,2,8,10,4 }
        );
        System.out.println(scheduling3);
    }

}
